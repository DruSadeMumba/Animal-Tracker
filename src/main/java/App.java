
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 2345;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2lajsvmr7vl06";
        Sql2o sql2o = new Sql2o(connectionString, "mzpamolmgkdtkl", "c0a03c32de7bbd946d36bba6a19df953546104d33d9df1b5a968543b28a173e4");

        Map<String, Object> model = new HashMap<String, Object>();

                //main page
        get("/", (request, response)
            -> new ModelAndView(model, "index.hbs"),
            new HandlebarsTemplateEngine());

                //sightings page
        get("/sightings", (request, response) -> {
            model.put("sightings", Sighting.all());
            System.out.println(Sighting.all());
            return new ModelAndView(model, "sightings.hbs");
        },new HandlebarsTemplateEngine());

                //new sighting
        get("/sighting/new", (request, response)
            -> new ModelAndView(model, "sighting-form.hbs"),
            new HandlebarsTemplateEngine());

        post("/sightings", (req, res) ->{
            Sighting sighting = new Sighting(req.queryParams("animalname"), req.queryParams("location"), req.queryParams("rangername"));
            sighting.save();
            Map<String, List<Sighting>> model2 = new HashMap<>();
            model2.put("sightings", Sighting.all());
            System.out.println(Sighting.all().get(0).getRangerName());
            return new ModelAndView(model2, "index.hbs");
        }, new HandlebarsTemplateEngine());


                //animals page
        get("/animals", (request, response)
            -> new ModelAndView(model, "animals.hbs"),
            new HandlebarsTemplateEngine());

                //new animal
        get("/animal/new", (request, response)
            -> new ModelAndView(model, "animal-form.hbs"),
            new HandlebarsTemplateEngine());

        post("/animals/endangered", (req, res) ->{
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(req.queryParams("name"), req.queryParams("age"), req.queryParams("health"), Integer.parseInt(req.queryParams("sightingId")));
            endangeredAnimal.save();
            model.put("animals", EndangeredAnimal.all());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/animals/new", (req, res) ->{
            UnendangeredAnimal unendangeredAnimal = new UnendangeredAnimal(req.queryParams("name"), Integer.parseInt(req.queryParams("sightingId")));
            unendangeredAnimal.save();
            model.put("animals", EndangeredAnimal.all());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
