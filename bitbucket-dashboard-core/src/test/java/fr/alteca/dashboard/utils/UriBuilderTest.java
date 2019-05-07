package fr.alteca.dashboard.utils;

import org.junit.Test;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;

public final class UriBuilderTest {

    @Test(expected = DashboardException.class)
    public void buildUriContexteNull() throws DashboardException {
        UriBuilder.buildUri(null);
    }

    @Test(expected = DashboardException.class)
    public void buildUriContexteVide() throws DashboardException {
        UriBuilder.buildUri(new Contexte());
    }

    @Test
    public void buildUriContexteAvecRepoName() throws DashboardException {
        UriBuilder.buildUri(new Contexte("toto"));
    }
}