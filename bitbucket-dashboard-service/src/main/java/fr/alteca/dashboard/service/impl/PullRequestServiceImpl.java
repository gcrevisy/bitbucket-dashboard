package fr.alteca.dashboard.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alteca.dashboard.dao.PullRequestDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.service.PullRequestService;
import fr.alteca.dashboard.utils.ModelValidator;

@Service
public class PullRequestServiceImpl implements PullRequestService {
  private Logger logger = LoggerFactory.getLogger(PullRequestServiceImpl.class);

  @Autowired
  private PullRequestDao pullRequestDao;

  public PullRequestServiceImpl() {
  }

  @Override
  public List<PullRequest> listerPullRequest(Contexte contexte) throws DashboardException {
	ModelValidator.validerContexte(contexte);
	logger.info("Entree dans la methode PullRequestServiceImpl#listerPullRequest : " + contexte.toString());
	List<PullRequest> liste = pullRequestDao.listerPullRequests(contexte);
	return liste;
  }

}