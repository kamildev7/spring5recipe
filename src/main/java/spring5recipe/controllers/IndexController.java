package spring5recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring5recipe.services.RecipeService;

/**
 * @author kamildev7 on 2018-08-02.
 */

@Controller
public class IndexController {

    private final RecipeService recipseService;

    public IndexController(RecipeService recipseService) {
        this.recipseService = recipseService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipseService.getRecipes());
        return "index";
    }

}
