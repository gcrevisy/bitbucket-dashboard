package fr.alteca.dashboard.service;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;

public interface RepositoryService {
    List<Repository> listerRepositories(Contexte contexte) throws DashboardException;
}