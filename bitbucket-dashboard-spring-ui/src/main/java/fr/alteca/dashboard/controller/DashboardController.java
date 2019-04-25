package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.converter.BrancheConverter;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.BrancheService;
import fr.alteca.dashboard.service.impl.BrancheServiceImpl;

@Controller
public class DashboardController {
    private Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        BrancheService service = new BrancheServiceImpl();
        List<Branche> liste = new ArrayList<Branche>();
        Contexte contexte = new Contexte("poc-junit", "gcrevisy");

        try {
            liste.addAll(service.controlerNom(contexte));
        } catch (DashboardException e) {
            logger.error("Erreur pendant la récupération des branches : " + contexte.toString());
        }

        List<BrancheView> branches = new ArrayList<BrancheView>();
        BrancheConverter converter = new BrancheConverter();
        for (Branche item : liste) {
            try {
                branches.add(converter.convertToViewModel(item));
            } catch (DashboardException e) {
                logger.error("Erreur pendant la conversion des branches : " + contexte.toString());
            }
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("branches", branches);

        return "home";
    }
}