package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.utils.ModelValidator;

public class BrancheDaoImpl extends AbstractDao implements BrancheDao {

    @Override
    public List<Branche> listerBranches(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        List<Branche> result = new ArrayList<Branche>();
        result.addAll(invokeRest(contexte));
        return result;
    }

}