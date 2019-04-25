package fr.alteca.dashboard.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;

public class BrancheConverter implements Converter<Branche, BrancheView> {

    @Override
    public Branche convertToData(BrancheView item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversion");

        Branche result = new Branche();
        try {
            result.setAuteur(item.getAuteur());
            if (StringUtils.isNotBlank(item.getDateCreation())) {
                result.setDateCreation(new SimpleDateFormat("dd/MM/yyyy").parse(item.getDateCreation()));
            }
            result.setName(item.getName());
        } catch (ParseException e) {
            throw new DashboardException(e.getMessage());
        }

        return result;
    }

    @Override
    public BrancheView convertToViewModel(Branche item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversion");

        BrancheView result = new BrancheView();

        result.setAuteur(item.getAuteur());
        if (item.getDateCreation() != null) {
            result.setDateCreation(new SimpleDateFormat("dd/MM/yyyy").format(item.getDateCreation()));
        } else {
            result.setDateCreation("empty");
        }
        result.setName(item.getName());

        return result;
    }

}