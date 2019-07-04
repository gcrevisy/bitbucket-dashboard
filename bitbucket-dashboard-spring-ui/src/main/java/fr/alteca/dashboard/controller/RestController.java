package fr.alteca.dashboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.alteca.dashboard.exception.DashboardException;
import fr.alteca.dashboard.model.Branche;
import fr.alteca.dashboard.model.Contexte;
import fr.alteca.dashboard.service.impl.BrancheServiceImpl;

@Controller
public class RestController {

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @ResponseBody
    @RequestMapping(value = { "/brancheNamingError" })
    public List<Branche> listBranchesNamingError() throws DashboardException {
        logger.info("Entrée dans la méthode RestController#listBranches");
        return new BrancheServiceImpl().controlerNom(new Contexte("gcrevisy", "poc-junit"));
    }

    @ResponseBody
    @RequestMapping(value = { "/brancheDateError" })
    public List<Branche> listBranchesDateError() throws DashboardException {
        logger.info("Entrée dans la méthode RestController#listBranches");
        return new BrancheServiceImpl().controlerDateCreation(new Contexte("gcrevisy", "poc-junit"));
    }

}