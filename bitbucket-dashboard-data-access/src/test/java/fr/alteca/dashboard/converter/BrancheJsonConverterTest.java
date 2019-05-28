package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.json.AuteurJson;
import fr.alteca.dashboard.model.json.BrancheJson;
import fr.alteca.dashboard.model.json.TargetJson;
import fr.alteca.dashboard.model.json.UserJson;

public class BrancheJsonConverterTest {

    @Test(expected = DashboardException.class)
    public void convertSourceNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        converter.convertToModel(null);
    }

    @Test(expected = DashboardException.class)
    public void convertSourceDateInvalide() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        converter.convertToModel(getJsonDateInvalid());
    }

    @Test
    public void convertSourceOk() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        Branche branche = converter.convertToModel(getJson());

        Assert.assertEquals(getModel(), branche);
    }

    @Test
    public void convertSourceOkDateNull() throws DashboardException {
        BrancheJsonConverter converter = new BrancheJsonConverter();
        Branche branche = converter.convertToModel(getJsonDateNull());

        Assert.assertEquals(getModelDateNull(), branche);
    }

    private Branche getModel() {
        Branche branche = new Branche();
        branche.setName("name");
        branche.setAuteur("username");
        GregorianCalendar gc = new GregorianCalendar();
        try {
            gc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-22T05:31:36+00:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        branche.setDateCreation(gc);
        return branche;
    }

    private Branche getModelDateNull() {
        Branche branche = new Branche();
        branche.setName("name");
        branche.setAuteur("username");
        branche.setDateCreation(null);
        return branche;
    }

    private BrancheJson getJson() {
        BrancheJson branche = new BrancheJson("name",
                new TargetJson(new AuteurJson(new UserJson("username")), "2019-05-22T05:31:36+00:00"));
        return branche;
    }

    private BrancheJson getJsonDateNull() {
        BrancheJson branche = new BrancheJson("name", new TargetJson(new AuteurJson(new UserJson("username")), null));
        return branche;
    }

    private BrancheJson getJsonDateInvalid() {
        BrancheJson branche = new BrancheJson("name",
                new TargetJson(new AuteurJson(new UserJson("username")), "lskfjskdfjkldjf"));
        return branche;
    }

}