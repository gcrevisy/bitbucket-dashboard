package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.converter.BrancheConverter;
import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.BrancheView;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.BrancheService;
import fr.alteca.dashboard.service.RepositoryService;
import fr.alteca.dashboard.service.impl.BrancheServiceImpl;
import fr.alteca.dashboard.service.impl.RepositoryServiceImpl;

@Controller
public class DashboardController {
    private Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        Contexte contexte = new Contexte("", "");

        RepositoryService rs = new RepositoryServiceImpl();
        List<Repository> liste = new ArrayList<Repository>();

        try {
            liste.addAll(rs.listerRepositories(contexte));
        } catch (DashboardException e) {
            logger.warn("Erreur pendant le chargement des repositories" + e.getMessage());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("repositories", liste);

        return "home";
    }

    @RequestMapping(value = { "/repository/{repositoryName}" }, method = RequestMethod.GET)
    public String projects(Model model, @PathVariable("repositoryName") String repositoryName) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        Contexte contexte = new Contexte(repositoryName, "");

        model.addAttribute("contexte", contexte);
        model.addAttribute("branches", new ArrayList<BrancheView>());

        return "home";
    }

    @RequestMapping(value = { "/repository/{repositoryName}/project/{projectName}" }, method = RequestMethod.GET)
    public String homePage(Model model, @PathVariable("repositoryName") String repositoryName,
            @PathVariable("projectName") String projectName) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        BrancheService service = new BrancheServiceImpl();
        List<Branche> liste = new ArrayList<Branche>();
        Contexte contexte = new Contexte(repositoryName, projectName);

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