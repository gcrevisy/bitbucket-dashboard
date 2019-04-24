package fr.alteca.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.alteca.dashboard.model.Branche;

@Controller
public class RestController {

    @ResponseBody
    @RequestMapping(value = { "/branches" })
    public List<Branche> listBranches() {
        List<Branche> resuList = new ArrayList<Branche>();
        resuList.add(new Branche("name1", null, "auteur"));
        resuList.add(new Branche("name2", null, "auteur"));
        resuList.add(new Branche("name3", null, "auteur"));
        resuList.add(new Branche("name4", null, "auteur"));
        resuList.add(new Branche("name5", null, "auteur"));
        return resuList;
    }

}