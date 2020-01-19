package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;

public interface PullRequestService {

    /**
     * Service listant les pulls requests en attente.
     * @param contexte {@link Contexte}
     * @return Liste de {@link PullRequest}
     * @throws DashboardException
     */
    List<PullRequest> listerPullRequest(Contexte contexte) throws DashboardException;

}