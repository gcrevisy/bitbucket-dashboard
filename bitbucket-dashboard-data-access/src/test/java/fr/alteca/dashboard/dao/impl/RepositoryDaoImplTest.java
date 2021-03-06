package fr.alteca.dashboard.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;

public class RepositoryDaoImplTest {

    @Test
    public void listerRepositoriesTest() throws DashboardException {
        RepositoryDao dao = new RepositoryDaoImpl();
        List<Repository> liste = dao.listerRepositories(new Contexte("gcrevisy"));
        Assert.assertTrue(liste != null);
    }
}