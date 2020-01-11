package fr.alteca.dashboard.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.RepositoryService;

public class RepositoryServiceImplTest {

    @Test
    public void listerRepositories() throws DashboardException {
        RepositoryService service = new RepositoryServiceImpl(getRepositoryDao());
        assertTrue(service.listerRepositories(new Contexte("toto")) != null);
    }

    private RepositoryDao getRepositoryDao() {
        return new RepositoryDao() {

            @Override
            public List<Repository> listerRepositories(Contexte contexte) {
                return new ArrayList<Repository>();
            }
        };
    }
}