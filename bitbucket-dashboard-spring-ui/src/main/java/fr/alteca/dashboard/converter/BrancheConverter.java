package fr.alteca.dashboard.converter;

import java.util.List;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;
import fr.alteca.dashboard.utils.ModelValidator;

public class BrancheConverter implements Converter<Branche, BrancheView> {

    @Override
    public Branche convertToData(BrancheView item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversiion");
        return null;
    }

    @Override
    public BrancheView convertToViewModel(Branche item) throws DashboardException {
        if (item == null)
            throw new DashboardException("Item null pendant la conversiion");
        return null;
    }

}