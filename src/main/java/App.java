import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(2345);
        Map<String, Object> model = new HashMap<String, Object>();

                //main page
        get("/", (request, response)
            -> new ModelAndView(model, "index.hbs"),
            new HandlebarsTemplateEngine());

                //sightings page
        get("/sightings", (request, response)
            -> new ModelAndView(model, "sightings.hbs"),
            new HandlebarsTemplateEngine());

                //new sighting
        get("/sighting/new", (request, response)
            -> new ModelAndView(model, "sighting-form.hbs"),
            new HandlebarsTemplateEngine());

                //animals page
        get("/animals", (request, response)
            -> new ModelAndView(model, "animals.hbs"),
            new HandlebarsTemplateEngine());

                //new animal
        get("/animal/new", (request, response)
            -> new ModelAndView(model, "animal-form.hbs"),
            new HandlebarsTemplateEngine());
    }
}
