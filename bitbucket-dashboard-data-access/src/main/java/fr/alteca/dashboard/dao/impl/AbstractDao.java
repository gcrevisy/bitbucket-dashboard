package fr.alteca.dashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import fr.alteca.dashboard.model.Contexte;

public abstract class AbstractDao {

    protected <T> List<T> invokeRest(Contexte contexte) {

        List<T> result = new ArrayList<T>();
        return result;
    }

}