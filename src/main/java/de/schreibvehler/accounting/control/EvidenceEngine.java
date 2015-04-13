package de.schreibvehler.accounting.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.schreibvehler.accounting.entities.*;

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

    public List<Evidence> findAll(List<EvidenceType> types) {
        //TODO
        return findAll();
//        List<Evidence> evidences = em.createNamedQuery("ALL_EVIDENCES_BY_TYPES", Evidence.class).setParameter(param, value).getResultList();
//        return evidences;
    }

    public Evidence update(Evidence evidence) {
        return em.merge(evidence);
    }

    public void delete(Integer id) {
        Evidence evidence = new Evidence();
        evidence.setId(id);
        em.remove(em.contains(evidence) ? evidence : em.merge(evidence));
    }
}
