package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;

public interface PullRequestService {

    /**
     * 
     * @param contexte
     * @return
     * @throws DashboardException
     */
    List<PullRequest> listerPullRequest(Contexte contexte) throws DashboardException;

}