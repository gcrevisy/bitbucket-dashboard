package fr.alteca.dashboard.converter;

import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;

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

}