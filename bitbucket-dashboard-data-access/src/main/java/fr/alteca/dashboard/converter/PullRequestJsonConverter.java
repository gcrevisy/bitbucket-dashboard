package fr.alteca.dashboard.converter;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.json.PullRequestJson;

public class PullRequestJsonConverter implements Converter<PullRequestJson, PullRequest> {

    @Override
    public PullRequest convertToModel(PullRequestJson item) throws DashboardException {
        PullRequest result = new PullRequest();

        result.setName(item.getTitle());
        // result.setAuteur(item.getAuthor().getUser().getNickname());

        return result;
    }

}