package fr.alteca.dashboard.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;

public class BrancheServiceImplTest {

    @Test
    public void controlerNomOk()  {
        BrancheServiceImpl service = new BrancheServiceImpl(getBrancheDao(new ArrayList<Branche>()));
        assertTrue(service.controlerNom(getListBranchesOk()).size() == 0);
    }

    @Test
    public void controlerNomMasterOk()  {
        BrancheServiceImpl service = new BrancheServiceImpl(getBrancheDao(new ArrayList<Branche>()));
        assertTrue(service.controlerNom(getListBranchesMasterOnly()).size() == 0);
    }

    @Test
    public void controlerNomKo()  {
        BrancheServiceImpl service = new BrancheServiceImpl(getBrancheDao(new ArrayList<Branche>()));
        assertTrue(service.controlerNom(getListBranchesKo()).size() > 0);
    }

    @Test
    public void controlerDateCreationOk()  {
        BrancheServiceImpl service = new BrancheServiceImpl(getBrancheDao(new ArrayList<Branche>()));
        assertTrue(service.controlerDateCreation(getListBranchesOk()).size() > 0);
    }

    private List<Branche> getListBranchesOk() {
        GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();

        List<Branche> liste = new ArrayList<Branche>();
        date.add(Calendar.DAY_OF_MONTH, -5);
        liste.add(new Branche("id", "feature/toto", date, "gcrevisy"));

        return liste;
    }

    private List<Branche> getListBranchesKo() {
        GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();

        List<Branche> liste = new ArrayList<Branche>();

        date.add(Calendar.DAY_OF_MONTH, -10);
        liste.add(new Branche("id", "toto", date, "gcrevisy"));

        return liste;
    }

    private List<Branche> getListBranchesMasterOnly() {
        GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();

        List<Branche> liste = new ArrayList<Branche>();
        liste.add(new Branche("id", "master", date, "gcrevisy"));

        return liste;
    }

    private BrancheDao getBrancheDao(List<Branche> list) {
        return new BrancheDao() {

            @Override
            public List<Branche> listerBranches(Contexte contexte) throws DashboardException {
                List<Branche> result = new ArrayList<Branche>();
                result.addAll(list);
                return result;
            }
        };
    }
}