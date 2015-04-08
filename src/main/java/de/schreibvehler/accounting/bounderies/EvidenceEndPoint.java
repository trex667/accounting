package de.schreibvehler.accounting.bounderies;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import de.schreibvehler.accounting.control.EvidenceEngine;
import de.schreibvehler.accounting.entities.Evidence;

@Path("evidence")
@Produces(MediaType.APPLICATION_JSON)
//@Stateless
public class EvidenceEndPoint {

    @Inject
    private EvidenceEngine evidenceEngine;
    
    @GET
    @Path("{id}")
    public Evidence getEvidence(@PathParam("id") Integer id) {
        Evidence evidence = evidenceEngine.findById(id);
        if(evidence == null) {
            throw new NotFoundException(String.format("Could not find Evidence with id '%d'", id));
        }
        return evidence;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvidence(Evidence evidence, @Context UriInfo uriInfo) {
        evidenceEngine.save(evidence);
        URI createdUri = uriInfo.getAbsolutePathBuilder().path(EvidenceEndPoint.class, "getEvidence").resolveTemplate("id", evidence.getId()).build();
        return Response.created(createdUri).build();
    }

    // http://localhost:8080/accounting/evidence/echo/Hallo Zwackelmann
    @GET
    @Path("echo/{message}")
    public String echo(@PathParam("message") String message) {
        return message;
    }

}
