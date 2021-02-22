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

        post("/squad/new",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String title = req.queryParams("title");
            int size = Integer.parseInt(req.queryParams("size"));
            String cause = req.queryParams("cause");

            Squad newSquad = new Squad(title,size,cause);

            //placeholder for success page variable
            req.session().attribute("item",title);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
