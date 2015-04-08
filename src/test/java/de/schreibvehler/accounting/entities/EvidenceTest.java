package de.schreibvehler.accounting.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.json.JsonObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class EvidenceTest {
    @Test
    public void equals_sameOblectIsEquals() throws Exception {
        Evidence evidence = new Evidence();

        assertThat(evidence).isEqualTo(evidence);
    }

    @Test
    public void equals_otherClassOblectIsNotEquals() throws Exception {
        Evidence evidence = new Evidence();

        assertThat(evidence).isNotEqualTo(new Object());
    }

    @Test
    public void equals_primaryKeyIsEquals() throws Exception {
        Evidence evidence = new Evidence();
        Integer pk = 4711;
        evidence.setId(pk);

        Evidence otherEvidence = new Evidence();
        otherEvidence.setId(pk);
        assertThat(evidence).isEqualTo(otherEvidence);
    }

    @Test
    public void equals_primaryKeyNullIsEquals() throws Exception {
        Evidence evidence = new Evidence();
        Integer pk = null;
        evidence.setId(pk);

        Evidence otherEvidence = new Evidence();
        otherEvidence.setId(pk);
        assertThat(evidence).isEqualTo(otherEvidence);
    }

    @Test
    public void equals_primaryKeyIsNotEquals() throws Exception {
        Evidence evidence = new Evidence();
        evidence.setId(4711);

        Evidence otherEvidence = new Evidence();
        otherEvidence.setId(9999);
        assertThat(evidence).isNotEqualTo(otherEvidence);
    }
    
    @Test
    public void equals_onlyPkAttributeMustBeEquals() throws Exception {
        Evidence evidence = new Evidence();
        Integer pk = 4711;
        evidence.setId(pk);
        evidence.setValue(123.23F);
        evidence.setDate(new Date());
        evidence.setDescription("description");
        

        Evidence otherEvidence = new Evidence();
        otherEvidence.setId(pk);
        otherEvidence.setValue(999.07F);
        otherEvidence.setDate(null);
        otherEvidence.setDescription("other description");
        assertThat(evidence).isEqualTo(otherEvidence);
    }
    
//    @Test
//    public void blub() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        Evidence evidence = new Evidence();
//        Integer pk = 4711;
//        evidence.setId(pk);
//        evidence.setValue(123.23F);
//        evidence.setDate(new Date());
//        evidence.setDescription("description");
//        
//        mapper.writeValue(new File("d://tmp/evidence.json"), evidence);
//        
//    }
}
