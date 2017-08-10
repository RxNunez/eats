import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import Food.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("restaurants", Restaurant.getInstances());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/restaurants/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Restaurant place = Restaurant.findById(Integer.parseInt(request.params(":id")));
            model.put("place", place);
            return new ModelAndView(model, "restaurant-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/restaurants/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String restaurantName;
            String neighborhood;
            String genre;
            String favoriteDish;
            Integer rating;
            Restaurant newRestaurant = new Restaurant(restaurantName, neighborhood, genre, favoriteDish, rating);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
