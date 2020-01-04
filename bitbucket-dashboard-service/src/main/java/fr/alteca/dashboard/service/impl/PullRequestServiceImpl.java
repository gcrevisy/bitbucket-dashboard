package fr.alteca.dashboard.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.dao.PullRequestDao;
import fr.alteca.dashboard.dao.impl.PullRequestDaoImpl;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.service.PullRequestService;
import fr.alteca.dashboard.utils.ModelValidator;

public class PullRequestServiceImpl implements PullRequestService {
    private Logger logger = LoggerFactory.getLogger(PullRequestServiceImpl.class);
    private PullRequestDao pullRequestDao;

    public PullRequestServiceImpl() {
        pullRequestDao = new PullRequestDaoImpl();
    }

    @Override
    public List<PullRequest> listerPullRequest(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        logger.info("Entree dans la methode BrancheService#controlerNom : " + contexte.toString());
        return pullRequestDao.listerPullRequests(contexte);
    }

}