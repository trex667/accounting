package de.schreibvehler.accounting.bounderies;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import de.schreibvehler.accounting.control.EvidenceEngine;
import de.schreibvehler.accounting.entities.*;

@Path("evidences")
@Produces(MediaType.APPLICATION_JSON)
public class EvidenceEndPoint {

    @Inject
    private EvidenceEngine evidenceEngine;
    
    @GET
    public List<Evidence> getEvidences() {
      List<Evidence> allEvidences = evidenceEngine.findAll();
      return allEvidences;
    }

    @GET
    public List<Evidence> getEvidences( @QueryParam("type") List<EvidenceType> types) {
        List<Evidence> allEvidences = evidenceEngine.findAll(types);
        return allEvidences;
    }
    
    @GET
    @Path("{id}")
    public Evidence getEvidence(@PathParam("id") Integer id) {
        Evidence evidence = evidenceEngine.findById(id);
        if(evidence == null) {
            throw new NotFoundException(String.format("Could not find Evidence with id '%d'", id));
        }
        return evidence;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvidence(Evidence evidence, @Context UriInfo uriInfo) {
        evidenceEngine.save(evidence);
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(EvidenceEndPoint.class, "getEvidence").resolveTemplate("id", evidence.getId()).build();
        return Response.created(createdUri).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Evidence updateEvidence(@PathParam("id") int id, Evidence evidence) {
        evidence.setId(id);
        Evidence result = evidenceEngine.update(evidence);
        return result;
    }

    @DELETE
    @Path("{id}")
    public void deleteEvidence(@PathParam("id") int id) {
        evidenceEngine.delete(id);
    }


    // http://localhost:8080/accounting/evidences/echo/Hallo Zwackelmann
    @GET
    @Path("echo/{message}")
    public String echo(@PathParam("message") String message) {
        return message;
    }
}
