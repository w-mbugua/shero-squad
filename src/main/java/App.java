import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //showing all heroes
        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();

            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);

            ArrayList<Hero> members = Hero.getAll();
            model.put("heroes",members);

            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
