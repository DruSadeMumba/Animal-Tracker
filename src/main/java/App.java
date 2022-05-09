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

        get("/", (request, response)
            -> new ModelAndView(model, "index.hbs"),
            new HandlebarsTemplateEngine());
    }
}
