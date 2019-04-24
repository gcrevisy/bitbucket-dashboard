package fr.alteca.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.BrancheService;

public class BrancheServiceImpl implements BrancheService {

    private BrancheDao brancheDao;

    public BrancheServiceImpl() {
    }

    public BrancheServiceImpl(BrancheDao brancheDao) {
        this.brancheDao = brancheDao;
    }

    @Override
    public List<Branche> controlerNom(Contexte contexte) throws DashboardException {
        List<Branche> liste = new ArrayList<Branche>();// brancheDao.listerBranches(contexte);
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
    public List<Branche> controlerDateCreation(Contexte contexte) {
        return null;
    }

}