package fr.alteca.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.Repository;

public class DashboardServiceTest {

    @Test
    public void listerPullRequestsOk() throws DashboardException {
        DashboardService service = new DashboardService(getRepositoryService(), getBrancheService(),
                getPullRequestService());
        service.listerPullRequests(new Contexte());
    }

    private PullRequestService getPullRequestService() {
        PullRequestService servie = new PullRequestService() {

            @Override
            public List<PullRequest> listerPullRequest(Contexte contexte) throws DashboardException {
                // TODO Auto-generated method stub
                return new ArrayList<PullRequest>();
            }
        };
        return servie;
    }

    private BrancheService getBrancheService() {
        BrancheService service = new BrancheService() {

            @Override
            public List<Branche> listerBranche(Contexte contexte) throws DashboardException {
                // TODO Auto-generated method stub
                return new ArrayList<Branche>();
            }
        };
        return service;
    }

    private RepositoryService getRepositoryService() {
        RepositoryService service = new RepositoryService() {

            @Override
            public List<Repository> listerRepositories(Contexte contexte) throws DashboardException {
                // TODO Auto-generated method stub
                return new ArrayList<Repository>();
            }
        };
        return service;
    }
}