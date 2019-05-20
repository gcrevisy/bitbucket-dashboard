package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.json.BrancheJson;

public class BrancheJsonConverter implements Converter<BrancheJson, Branche> {

    private Logger logger = LoggerFactory.getLogger(BrancheJsonConverter.class);

    @Override
    public BrancheJson convertToJsonModel(Branche item) throws DashboardException {
        BrancheJson result = new BrancheJson();
        return result;
    }

    @Override
    public Branche convertToModel(BrancheJson item) throws DashboardException {
        Branche result = new Branche();

        result.setName(item.getName());
        result.setAuteur(item.getTarget().getAuthor().getUser().getUsername());
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new SimpleDateFormat("yyy-MM-dd").parse(item.getTarget().getDate()));
            result.setDateCreation(gc);
        } catch (ParseException e) {
            logger.error("Erreur pendant la conversion de date", e.getMessage());
            throw new DashboardException("Erreur pendant la conversion de date", e);
        }

        return result;
    }

}