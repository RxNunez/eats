import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import Food.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        //get: homepage/displays all posts
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Restaurant> listOfPlaces = Restaurant.getInstances();
            model.put("restaurants", Restaurant.getInstances());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        //get: show form to enter new post
        get("/restaurants/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"restaurant-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process new post form
        post("/restaurants/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Restaurant> listOfPlaces = Restaurant.getInstances();
            String restaurantName = request.queryParams("restaurantName");
            String neighborhood = request.queryParams("neighborhood");
            String genre = request.queryParams("genre");
            String favoriteDish = request.queryParams("favoriteDish");
            Integer rating= Integer.parseInt(request.queryParams("rating"));
            Restaurant newRestaurant = new Restaurant(restaurantName, neighborhood, genre, favoriteDish, rating);
            model.put("restaurants", listOfPlaces);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
        //get: Edit entry
        get("/restaurants/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int idOfPlace = Integer.parseInt(request.params("id"));
            Restaurant editPlace = Restaurant.findById(idOfPlace);
            model.put("editPlace", editPlace);
            return new ModelAndView(model, "restaurant-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: Fix updated post
        post("/restaurants/:id",(request, response) -> {
            Map<String, Object>model = new HashMap<>();
            ArrayList<Restaurant> listOfPlaces = Restaurant.getInstances();
            String restaurantName = request.queryParams("restaurantName");
            String neighborhood = request.queryParams("neighborhood");
            String genre = request.queryParams("genre");
            String favoriteDish = request.queryParams("favoriteDish");
            Integer rating= Integer.parseInt(request.queryParams("rating"));
            int idOfPLace = Integer.parseInt(request.params("id"));
            Restaurant editPlace = Restaurant.findById(idOfPLace);
            editPlace.update(restaurantName, neighborhood,genre,favoriteDish,rating);
            model.put("restaurants", listOfPlaces);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
        //get: delete all posts
        get("/delete", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            Restaurant.clearAllRestaurants();;
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
