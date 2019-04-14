package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.alteca.dashboard.model.BrancheView;

@Controller
public class HomeController {

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        List<BrancheView> liste = new ArrayList<BrancheView>();

        model.addAttribute("branches", liste);

        return "home";
    }
}