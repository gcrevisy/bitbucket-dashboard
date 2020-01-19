package fr.alteca.dashboard.converter;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.model.json.RepositoryJson;

public class RepositoryJsonCoverter implements Converter<RepositoryJson, Repository> {

    @Override
    public Repository convertToModel(RepositoryJson item) throws DashboardException {
        Repository result = new Repository();

        result.setName(item.getName());
        result.setScm(item.getScm());

        return result;
    }

}