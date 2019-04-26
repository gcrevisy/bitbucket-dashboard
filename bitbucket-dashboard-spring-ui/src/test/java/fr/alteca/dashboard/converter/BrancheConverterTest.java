package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
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

    @Ignore
    @Test
    public void convertSourceOk() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        Branche branche = converter.convertToData(getModel());

        Assert.assertTrue(getData().equals(branche));
    }

    @Ignore
    @Test
    public void convertTargetOk() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        BrancheView branche = converter.convertToViewModel(getData());
        Assert.assertEquals(getModel(), branche);
    }

    @Test
    public void convertSourceOkDateNull() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        Branche branche = converter.convertToData(getModelDateNull());

        Assert.assertTrue(getDataDateNull().equals(branche));
    }

    @Test
    public void convertTargetOkDateNull() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        BrancheView branche = converter.convertToViewModel(getDataDateNull());
        Assert.assertEquals(getModelDateNull(), branche);
    }

    private Branche getData() throws DashboardException {
        Branche branche = new Branche();
        branche.setAuteur("auteur");
        try {
            branche.setDateCreation(new SimpleDateFormat("dd/MM/yyyy").parse("24/04/2019"));
        } catch (ParseException e) {
            throw new DashboardException(e.getMessage());
        }
        branche.setName("name");
        return branche;
    }

    private BrancheView getModel() {
        BrancheView branche = new BrancheView();
        branche.setAuteur("auteur");
        branche.setDateCreation(new SimpleDateFormat("dd/MM/yyyy").format(new Date(2019, 04, 24)));
        branche.setName("name");
        return branche;
    }

    private Branche getDataDateNull() {
        Branche branche = new Branche();
        branche.setAuteur("auteur");
        branche.setDateCreation(null);
        branche.setName("name");
        return branche;
    }

    private BrancheView getModelDateNull() {
        BrancheView branche = new BrancheView();
        branche.setAuteur("auteur");
        branche.setDateCreation(null);
        branche.setName("name");
        return branche;
    }

}