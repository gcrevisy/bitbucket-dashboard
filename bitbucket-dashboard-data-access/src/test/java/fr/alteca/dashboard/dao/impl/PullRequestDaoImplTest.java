package fr.alteca.dashboard.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.dao.PullRequestDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;

public class PullRequestDaoImplTest {

    @Test
    public void listerPullRequestsTest() throws DashboardException {
        PullRequestDao dao = new PullRequestDaoImpl();
        List<PullRequest> liste = dao.listerPullRequests(new Contexte("gcrevisy", "poc-junit"));
        Assert.assertNotNull(liste);
    }
}