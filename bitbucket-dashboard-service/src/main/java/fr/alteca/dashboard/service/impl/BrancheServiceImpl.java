package fr.alteca.dashboard.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alteca.dashboard.dao.BrancheDao;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.BrancheService;
import fr.alteca.dashboard.utils.ModelValidator;

@Service
public class BrancheServiceImpl implements BrancheService {
    private Logger logger = LoggerFactory.getLogger(BrancheServiceImpl.class);

    @Autowired
    private BrancheDao brancheDao;

    public BrancheServiceImpl() {
    }

    public BrancheServiceImpl(BrancheDao brancheDao) {
        this.brancheDao = brancheDao;
    }

    protected List<Branche> controlerNom(List<Branche> liste) {
        logger.info("Entree dans la methode BrancheService#controlerNom ");

        List<Branche> result = new ArrayList<Branche>();

        for (Branche item : liste) {

            if ("master".equals(item.getName())) {
                continue;
            }

            if (StringUtils.isNotBlank(item.getName()) && !item.getName().startsWith("feature/")) {
                result.add(item);
            }
        }

        return result;
    }

    protected List<Branche> controlerDateCreation(List<Branche> liste) {

        logger.info("Entree dans la methode BrancheService#controlerNom");

        List<Branche> result = new ArrayList<Branche>();
        GregorianCalendar today = (GregorianCalendar) GregorianCalendar.getInstance();

        String date = new SimpleDateFormat("dd-MM-yyyy").format(today.getTime());
        logger.info(date);
        for (Branche item : liste) {

            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(item.getDateCreation().getTime());
            gc.add(GregorianCalendar.DAY_OF_MONTH, 4);
            date = new SimpleDateFormat("dd-MM-yyyy").format(gc.getTime());
            logger.info(date);
            if (today.compareTo(gc) > 0)
                result.add(item);
        }

        return result;
    }

    @Override
    public List<Branche> listerBranche(Contexte contexte) throws DashboardException {
        ModelValidator.validerContexte(contexte);
        logger.info("Entree dans la methode BrancheService#listerBranche : " + contexte);
        List<Branche> result = new ArrayList<Branche>();

        List<Branche> liste = brancheDao.listerBranches(contexte);

        result.addAll(controlerDateCreation(liste));
        result.addAll(controlerNom(liste));

        return result;
    }

}