package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

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
public class HomeController {

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        BrancheService service = new BrancheServiceImpl();
        List<Branche> liste = new ArrayList<Branche>();
        try {
            liste.addAll(service.controlerNom(new Contexte()));
        } catch (DashboardException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<BrancheView> branches = new BrancheConverter().convertToViewModel(liste);

        model.addAttribute("branches", branches);

        return "home";
    }
}