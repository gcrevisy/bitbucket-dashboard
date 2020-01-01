package fr.alteca.dashboard.dao;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;

public interface PullRequestDao {

    List<PullRequest> listerPullRequests(Contexte contexte) throws DashboardException;

}