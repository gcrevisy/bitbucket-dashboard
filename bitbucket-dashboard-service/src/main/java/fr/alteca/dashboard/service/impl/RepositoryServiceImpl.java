package fr.alteca.dashboard.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.RepositoryService;
import fr.alteca.dashboard.utils.ModelValidator;

@Service
public class RepositoryServiceImpl implements RepositoryService {
    private Logger logger = LoggerFactory.getLogger(RepositoryServiceImpl.class);

    @Autowired
    private RepositoryDao repositoryDao;

    public RepositoryServiceImpl() {
    }

    public RepositoryServiceImpl(RepositoryDao repositoryDao) {
        this.repositoryDao = repositoryDao;
    }

    @Override
    public List<Repository> listerRepositories(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        logger.info("Entree dans la methode PullRequestServiceImpl#listerPullRequest : " + contexte.toString());
        return repositoryDao.listerRepositories(contexte);
    }
}