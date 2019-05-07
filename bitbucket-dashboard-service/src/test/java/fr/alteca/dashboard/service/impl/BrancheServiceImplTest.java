package fr.alteca.dashboard.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.BrancheService;

public class BrancheServiceImplTest {

    @Test
    public void controlerNomOk() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        assertTrue(service.controlerNom(new Contexte()).size() > 0);
    }

    @Test
    public void controlerDateCreationOk() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        assertTrue(service.controlerDateCreation(new Contexte()).size() > 0);
    }

    private BrancheDao getBrancheDao() {
        return new BrancheDao() {
            @Override
            public List<Branche> listerBranches(Contexte contexte) {
                List<Branche> liste = new ArrayList<Branche>();
                liste.add(new Branche("master", null, "gcrevisy"));
                liste.add(new Branche("feature/toto", null, "gcrevisy"));
                liste.add(new Branche("toto", null, "gcrevisy"));
                return liste;
            }
        };
    }
}