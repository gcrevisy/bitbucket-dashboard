package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.json.BrancheJson;

/**
 * Classe de mapping entre un objet de type {@link BrancheJson} vers un objet de
 * type {@link Branche}.
 */
public class BrancheJsonConverter implements Converter<BrancheJson, Branche> {

    private Logger logger = LoggerFactory.getLogger(BrancheJsonConverter.class);

    @Override
    public Branche convertToModel(BrancheJson item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversion");

        Branche result = new Branche();

        result.setName(item.getName());
        result.setAuteur(item.getTarget().getAuthor().getUser().getNickname());
        if (StringUtils.isNotBlank(item.getTarget().getDate())) {
            try {
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(item.getTarget().getDate()));
                result.setDateCreation(gc);
            } catch (ParseException e) {
                logger.error("Erreur pendant la conversion de date", e.getMessage());
                throw new DashboardException("Erreur pendant la conversion de date", e);
            }
        }

        return result;
    }

}