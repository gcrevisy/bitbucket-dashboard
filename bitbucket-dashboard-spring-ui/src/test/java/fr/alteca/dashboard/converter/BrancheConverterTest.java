package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheModel;

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

        Assert.assertEquals(getData(), branche);
    }

    @Test
    public void convertTargetOk() throws DashboardException {
        BrancheConverter converter = new BrancheConverter();
        BrancheModel branche = converter.convertToViewModel(getData());
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
        BrancheModel branche = converter.convertToViewModel(getDataDateNull());
        Assert.assertEquals(getModelDateNull(), branche);
    }

    private Branche getData() throws DashboardException {
        Branche branche = new Branche();
        branche.setAuteur("auteur");
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("24/04/2019"));
            branche.setDateCreation(gc);
        } catch (ParseException e) {
            throw new DashboardException(e.getMessage());
        }
        branche.setName("name");
        return branche;
    }

    private BrancheModel getModel() {
        BrancheModel branche = new BrancheModel();
        branche.setAuteur("auteur");
        branche.setDateCreation(
                new SimpleDateFormat("dd/MM/yyyy").format(new GregorianCalendar(2019, 03, 24).getTime()));
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

    private BrancheModel getModelDateNull() {
        BrancheModel branche = new BrancheModel();
        branche.setAuteur("auteur");
        branche.setDateCreation(null);
        branche.setName("name");
        return branche;
    }

}