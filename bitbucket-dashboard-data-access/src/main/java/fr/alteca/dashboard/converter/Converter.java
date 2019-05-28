package fr.alteca.dashboard.converter;

import fr.alteca.dashboard.exception.DashboardException;

public interface Converter<S, T> {

    T convertToModel(S item) throws DashboardException;

}