package fr.alteca.dashboard.service.impl;

import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public class PullRequestServiceImplTest {

    @Test(expected = DashboardException.class)
    public void listerPRContexteKo() throws DashboardException {
        PullRequestServiceImpl service = new PullRequestServiceImpl();
        service.listerPullRequest(new Contexte());
    }

}