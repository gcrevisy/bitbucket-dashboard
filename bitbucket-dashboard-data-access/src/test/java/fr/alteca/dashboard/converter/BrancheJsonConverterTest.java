package fr.alteca.dashboard.converter;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.json.BrancheJson;

public class BrancheJsonConverterTest {

    @Test(expected = DashboardException.class)
    public void convertSourceNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        converter.convertToJsonModel(null);
    }

    @Test(expected = DashboardException.class)
    public void convertTargetNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        converter.convertToModel(null);
    }

    @Test
    public void convertSourceOk() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        Branche branche = converter.convertToModel(getJson());

        Assert.assertEquals(getModel(), branche);
    }

    @Test
    public void convertTargetOk() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        BrancheJson branche = converter.convertToJsonModel(getModel());

        Assert.assertEquals(getJson(), branche);
    }

    @Test
    public void convertSourceOkDateNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        Branche branche = converter.convertToModel(getJsonDateNull());

        Assert.assertEquals(getModelDateNull(), branche);
    }

    @Test
    public void convertTargetOkDateNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        BrancheJson branche = converter.convertToJsonModel(getModelDateNull());
        Assert.assertEquals(getModelDateNull(), branche);
    }

    private Branche getModel() {
        Branche branche = new Branche();
        return branche;
    }

    private Branche getModelDateNull() {
        Branche branche = new Branche();
        return branche;
    }

    private BrancheJson getJson() {
        BrancheJson branche = new BrancheJson();
        return branche;
    }

    private BrancheJson getJsonDateNull() {
        BrancheJson branche = new BrancheJson();
        return branche;
    }

}