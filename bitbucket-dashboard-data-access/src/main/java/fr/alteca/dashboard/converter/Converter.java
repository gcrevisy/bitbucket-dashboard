package fr.alteca.dashboard.converter;

import fr.alteca.dashboard.exception.DashboardException;

public interface Converter<S, T> {

    S convertToJsonModel(T item) throws DashboardException;

    T convertToModel(S item) throws DashboardException;

}