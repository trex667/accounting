package de.schreibvehler.accounting.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.schreibvehler.accounting.entities.Evidence;

@Stateless
public class EvidenceEngine {

    @Inject
    EntityManager em;

    public void save(Evidence evidence) {
        em.persist(evidence);
    }

    public Evidence findById(Integer id) {
        return em.find(Evidence.class, id);
    }

    public List<Evidence> findAll() {
        List<Evidence> allEvidences = em.createNamedQuery("ALL_EVIDENCES", Evidence.class).getResultList();
        return allEvidences;
    }
}
