package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheModel;

public class BrancheConverter implements Converter<Branche, BrancheModel> {

    @Override
    public Branche convertToData(BrancheModel item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversion");

        Branche result = new Branche();
        try {
            result.setAuteur(item.getAuteur());
            if (StringUtils.isNotBlank(item.getDateCreation())) {
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(item.getDateCreation()));
                result.setDateCreation(gc);
            }
            result.setName(item.getName());
        } catch (ParseException e) {
            throw new DashboardException(e.getMessage());
        }

        return result;
    }

    @Override
    public BrancheModel convertToViewModel(Branche item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversion");

        BrancheModel result = new BrancheModel();

        result.setAuteur(item.getAuteur());
        if (item.getDateCreation() != null) {
            result.setDateCreation(new SimpleDateFormat("dd/MM/yyyy").format(item.getDateCreation().getTime()));
        }
        result.setName(item.getName());

        return result;
    }

}