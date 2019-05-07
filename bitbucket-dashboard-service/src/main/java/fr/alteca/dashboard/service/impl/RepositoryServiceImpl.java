package fr.alteca.dashboard.service.impl;

import java.util.List;

import fr.alteca.dashboard.dao.RepositoryDao;
import fr.alteca.dashboard.dao.impl.RepositoryDaoImpl;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.RepositoryService;

public class RepositoryServiceImpl implements RepositoryService {
    private RepositoryDao repositoryDao;

    public RepositoryServiceImpl() {
        repositoryDao = new RepositoryDaoImpl();
    }

    public RepositoryServiceImpl(RepositoryDao repositoryDao) {
        this.repositoryDao = repositoryDao;
    }

    @Override
    public List<Repository> listerRepositories(Contexte contexte) throws DashboardException {
        return repositoryDao.listerRepositories(contexte);
    }
}