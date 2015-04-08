package de.schreibvehler.accounting.control;

import javax.enterprise.inject.Produces;
import javax.persistence.*;

public class EntityManagerProvider {
    @PersistenceContext(unitName = "AccountingPersistenceUnit")
    private EntityManager em;

    @Produces
    public EntityManager createEntityManager() {
        return em;
    }
}
