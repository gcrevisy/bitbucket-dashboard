package fr.alteca.dashboard.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public class BrancheDaoImplTest {

    @Test
    public void listerRepositoriesTest() throws DashboardException {
        BrancheDao dao = new BrancheDaoImpl();
        List<Branche> liste = dao.listerBranches(new Contexte("gcrevisy", "poc-junit"));
        Assert.assertTrue(!liste.isEmpty());
    }
}