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
import fr.alteca.dashboard.model.PullRequest;
import fr.alteca.dashboard.model.Repository;
import fr.alteca.dashboard.service.BrancheService;
import fr.alteca.dashboard.service.PullRequestService;
import fr.alteca.dashboard.service.RepositoryService;

@Controller
public class DashboardController {
    private Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private BrancheService brancheService;

    @Autowired
    private PullRequestService pullRequestService;

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Entree dans la methode DashboardController#homePage : " + model.toString());

        Contexte contexte = new Contexte("", "");

        List<Repository> liste = new ArrayList<Repository>();

        try {
            liste.addAll(repositoryService.listerRepositories(contexte));
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
        contexte.setGettingBrancheInfo(true);

        List<Repository> liste = new ArrayList<Repository>();

        try {
            liste.addAll(repositoryService.listerRepositories(contexte));
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
        contexte.setGettingPullRequestInfo(true);

        List<PullRequest> pullrequests = new ArrayList<PullRequest>();

        try {
            List<Repository> repositories = repositoryService.listerRepositories(contexte);
            for (Repository repository : repositories) {
                contexte.setProjectName(repository.getName());
                pullrequests.addAll(pullRequestService.listerPullRequest(contexte));
            }
        } catch (DashboardException e) {
            logger.warn("Erreur pendant le chargement des repositories" + e.getMessage());
        }

        model.addAttribute("contexte", contexte);
        model.addAttribute("pullrequests", pullrequests);

        return "pullrequests";
    }

}