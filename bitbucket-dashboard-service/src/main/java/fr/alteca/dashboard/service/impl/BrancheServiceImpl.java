package fr.alteca.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.dao.impl.BrancheDaoImpl;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.BrancheService;

public class BrancheServiceImpl implements BrancheService {
    private Logger logger = LoggerFactory.getLogger(BrancheServiceImpl.class);
    private BrancheDao brancheDao;

    public BrancheServiceImpl() {
        brancheDao = new BrancheDaoImpl();
    }

    public BrancheServiceImpl(BrancheDao brancheDao) {
        this.brancheDao = brancheDao;
    }

    @Override
    public List<Branche> controlerNom(Contexte contexte) throws DashboardException {
        logger.info("Entree dans la methode BrancheService#controlerNom : " + contexte.toString());
        List<Branche> liste = brancheDao.listerBranches(contexte);
        List<Branche> result = new ArrayList<Branche>();

        for (Branche item : liste) {

            if ("master".equals(item.getName())) {
                continue;
            }

            if (StringUtils.isNotBlank(item.getName()) && !item.getName().startsWith("feature/")) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public List<Branche> controlerDateCreation(Contexte contexte) throws DashboardException {
        logger.info("Entree dans la methode BrancheService#controlerNom : " + contexte.toString());
        List<Branche> liste = brancheDao.listerBranches(contexte);
        List<Branche> result = new ArrayList<Branche>();

        for (Branche item : liste) {

            // FIXME corriger les controles sur les dates
            result.add(item);
        }

        return result;
    }

}