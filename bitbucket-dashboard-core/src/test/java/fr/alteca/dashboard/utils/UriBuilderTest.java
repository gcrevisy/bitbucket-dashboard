package fr.alteca.dashboard.utils;

import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;

public final class UriBuilderTest {

    @Test(expected = DashboardException.class)
    public void buildUriKo() throws DashboardException {
        UriBuilder.buildUri(null);
    }

}