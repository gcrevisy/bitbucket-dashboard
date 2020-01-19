package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.json.pullrequest.PullRequestJson;

public class PullRequestJsonConverter implements Converter<PullRequestJson, PullRequest> {
    private Logger logger = LoggerFactory.getLogger(PullRequestJsonConverter.class);

    @Override
    public PullRequest convertToModel(PullRequestJson item) throws DashboardException {
        PullRequest result = new PullRequest();
        result.setId(item.getId());
        result.setName(item.getTitle());
        result.setAuteur(item.getAuthor().getNickname());
        if (StringUtils.isNotBlank(item.getUpdated_on())) {
            try {
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(item.getUpdated_on()));
                result.setDateCreation(gc);
                result.setBrancheDepart(item.getSource().getBranch().getName());
                result.setBrancheArrivee(item.getDestination().getBranch().getName());
            } catch (ParseException e) {
                logger.error("Erreur pendant la conversion de date", e.getMessage());
                throw new DashboardException("Erreur pendant la conversion de date", e);
            }
        }
        return result;
    }

}