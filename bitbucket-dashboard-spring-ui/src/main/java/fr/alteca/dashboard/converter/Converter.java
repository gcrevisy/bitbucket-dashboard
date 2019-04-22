package fr.alteca.dashboard.converter;

public interface Converter<S, T> {

    S convertToData(T items);

    T convertToViewModel(S items);

}