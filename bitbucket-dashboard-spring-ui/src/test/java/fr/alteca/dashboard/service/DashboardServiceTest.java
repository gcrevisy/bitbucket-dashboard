package fr.alteca.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

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

    private PullRequestService getPullRequestService() throws DashboardException {
        PullRequestService service = Mockito.mock(PullRequestService.class);
        Mockito.when(service.listerPullRequest(Mockito.any(Contexte.class))).thenReturn(new ArrayList<PullRequest>());
        return service;
    }
    
    private BrancheService getBrancheService() throws DashboardException {
        BrancheService service = Mockito.mock(BrancheService.class);
        Mockito.when(service.listerBranche(Mockito.any(Contexte.class))).thenReturn(new ArrayList<Branche>());
        return service;
    }
    
    private RepositoryService getRepositoryService() throws DashboardException {
        RepositoryService service = Mockito.mock(RepositoryService.class);
        Mockito.when(service.listerRepositories(Mockito.any(Contexte.class))).thenReturn(new ArrayList<Repository>());
        return service;
    }
}