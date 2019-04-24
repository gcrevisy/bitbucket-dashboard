package fr.alteca.dashboard.converter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;

public class BrancheConverterTest {

    @Test(expected = DashboardException.class)
    public void convertSourceNull() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        converter.convertToData(null);
    }

    @Test(expected = DashboardException.class)
    public void convertTargetNull() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        converter.convertToViewModel(null);
    }

    @Test
    public void convertSourceOk() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        Branche branche = converter.convertToData(getModel());

        Assert.assertTrue(getData().equals(branche));
    }

    @Test
    public void convertTargetOk() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        BrancheView branche = converter.convertToViewModel(getData());
        Assert.assertEquals(getModel(), branche);
    }

    private Branche getData() {
        Branche branche = new Branche();
        branche.setAuteur("auteur");
        branche.setDateCreation(new Date(2019, 04, 24));
        branche.setName("name");
        return branche;
    }

    private BrancheView getModel() {
        BrancheView branche = new BrancheView();
        branche.setAuteur("auteur");
        branche.setDateCreation("24/04/2019");
        branche.setName("name");
        return branche;
    }

}