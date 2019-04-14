package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.model.Branche;

@Controller
public class HomeController {

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<Branche> liste = new ArrayList<Branche>();
        liste.add(new Branche());
        liste.add(new Branche());
        liste.add(new Branche());
        liste.add(new Branche());
        liste.add(new Branche());

        model.addAttribute("branches", liste);

        return "home";
    }
}