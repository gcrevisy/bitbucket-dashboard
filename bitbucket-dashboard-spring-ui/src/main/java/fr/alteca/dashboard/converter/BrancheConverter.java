package fr.alteca.dashboard.converter;

import java.util.List;

import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;

public class BrancheConverter implements Converter<List<Branche>, List<BrancheView>> {

    @Override
    public List<Branche> convertToData(List<BrancheView> items) {
        return null;
    }

    @Override
    public List<BrancheView> convertToViewModel(List<Branche> items) {
        return null;
    }

}