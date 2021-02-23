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
            req.session().attribute("var",title);
            model.put("var",req.session().attribute("var"));
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show one squad
        get("/squads/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params(":id"));
            Squad foundSquad = Squad.findById(idOfPostToFind);
            model.put("squad", foundSquad);
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero/form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hero/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Integer age = Integer.parseInt(req.queryParams("age"));
            String strength = req.queryParams("strength");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name,age,strength,weakness);

            //placeholder for success page variable
            req.session().attribute("var",name);
            model.put("var",req.session().attribute("var"));

            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
