package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.PullRequestService;
import fr.alteca.dashboard.service.RepositoryService;
import fr.alteca.dashboard.service.impl.PullRequestServiceImpl;
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

    @RequestMapping(value = { "/branches" }, method = RequestMethod.GET)
    public String branches(Model model) {
        logger.info("Entree dans la methode DashboardController#branches : " + model.toString());

        Contexte contexte = new Contexte("", "");

        RepositoryService rs = new RepositoryServiceImpl();
        List<Repository> liste = new ArrayList<Repository>();

        try {
            liste.addAll(rs.listerRepositories(contexte));
        } catch (DashboardException e) {
            logger.warn("Erreur pendant le chargement des repositories" + e.getMessage());
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

        RepositoryService rs = new RepositoryServiceImpl();
        PullRequestService prs = new PullRequestServiceImpl();
        List<PullRequest> pullrequests = new ArrayList<PullRequest>();

        try {
            pullrequests.addAll(prs.listerPullRequest(contexte));
        } catch (DashboardException e) {
            logger.warn("Erreur pendant le chargement des repositories" + e.getMessage());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("pullrequests", pullrequests); 

        return "pullrequests";
    }

}