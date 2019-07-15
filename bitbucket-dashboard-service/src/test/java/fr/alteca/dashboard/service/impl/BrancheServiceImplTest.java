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
import fr.alteca.dashboard.service.BrancheService;

public class BrancheServiceImplTest {

    @Test
    public void controlerNomOk() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        assertTrue(service.controlerNom(new Contexte("gcrevisy")).size() > 0);
    }

    @Test
    public void controlerDateCreationOk() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        assertTrue(service.controlerDateCreation(new Contexte("gcrevisy")).size() > 0);
    }

    @Test(expected = DashboardException.class)
    public void controlerNomContexteNull() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        service.controlerNom(null);
    }

    @Test(expected = DashboardException.class)
    public void controlerDateCreationContexteNull() throws DashboardException {
        BrancheService service = new BrancheServiceImpl(getBrancheDao());
        service.controlerDateCreation(null);
    }

    private BrancheDao getBrancheDao() {
        return new BrancheDao() {
            @Override
            public List<Branche> listerBranches(Contexte contexte) {

                GregorianCalendar date = (GregorianCalendar) GregorianCalendar.getInstance();

                List<Branche> liste = new ArrayList<Branche>();
                liste.add(new Branche("master", date, "gcrevisy"));

                date.add(Calendar.DAY_OF_MONTH, -5);
                liste.add(new Branche("feature/toto", date, "gcrevisy"));

                date.add(Calendar.DAY_OF_MONTH, -10);
                liste.add(new Branche("toto", date, "gcrevisy"));

                date.add(Calendar.DAY_OF_MONTH, -15);
                liste.add(new Branche("", date, "gcrevisy"));
                return liste;
            }
        };
    }
}