package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.model.RepositoryModel;
import fr.alteca.dashboard.service.DashboardService;

@Controller
public class DashboardController {
    private Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        Contexte contexte = new Contexte("", "");

        List<RepositoryModel> liste = new ArrayList<RepositoryModel>();

        try {
            liste.addAll(dashboardService.listerRepositories(contexte));
        } catch (DashboardException e) {
            logger.error("Erreur pendant la recuperation des repos ", e.getCause());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("repositories", liste);

        return "home";
    }

    @RequestMapping(value = { "/branches" }, method = RequestMethod.GET)
    public String branches(Model model) {
        logger.info("Entree dans la methode DashboardController#branches : " + model.toString());

        Contexte contexte = new Contexte("", "");
        contexte.setGettingBrancheInfo(true);

        List<Repository> liste = new ArrayList<Repository>();

        try {
            dashboardService.listerBranches(contexte);
        } catch (DashboardException e) {
            logger.error("Erreur pendant la recuperation des branches ", e.getCause());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("branches", liste);

        return "branches";
    }

    @RequestMapping(value = { "/pullrequests" }, method = RequestMethod.GET)
    public String pullrequests(Model model) {
        logger.info("Entree dans la methode DashboardController#pullrequests : " + model.toString());

        Contexte contexte = new Contexte("", "");
        contexte.setRepositoryName("gcrevisy");
        contexte.setGettingPullRequestInfo(true);

        List<RepositoryModel> listeItems = new ArrayList<RepositoryModel>();

        try {
            listeItems = dashboardService.listerPullRequests(contexte);
        } catch (DashboardException e) {
            logger.error("Erreur pendant la recuperation des pull requests", e.getCause());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("listeItems", listeItems);

        return "pullrequests";
    }

}