package fr.alteca.dashboard.converter;

import fr.alteca.dashboard.exception.DashboardException;

public interface Converter<S, T> {

    S convertToData(T item) throws DashboardException;

    T convertToViewModel(S item) throws DashboardException;

}