package Food;
import com.sun.org.apache.regexp.internal.RESyntaxException;

import java.util.ArrayList;


public class Restaurant {
    private String restaurantName;
    private String neighborhood;
    private String genre;
    private String favoriteDish;
    private int rating;
    private int id;
    private static int increment = 0;
    private static ArrayList<Restaurant> instances = new ArrayList<>();

    public Restaurant(String restaurantName, String neighborhood, String genre, String favoriteDish, int rating){
        this.favoriteDish= favoriteDish;
        this.neighborhood = neighborhood;
        this.rating = rating;
        this.genre = genre;
        this.restaurantName = restaurantName;
        instances.add(this);
        increment++;
        this.id = increment;
    }

    public static void clearAllRestaurants() {
        instances.clear();
        increment = 0;
    }
    public static Restaurant findById(int id){
        Restaurant test= null;
        for (Restaurant instance : instances){
            if(instance.getId() == id){
                test = instance;
            }
        }
        return test;
    }
    public static ArrayList<Restaurant> searchByNeighborhood(String neighborhood){
        ArrayList<Restaurant> test = new ArrayList<>();
        for (Restaurant instance : instances){
            if(instance.getNeighborhood().equals(neighborhood)){
                test.add(instance);
            }
        }
        return test;
    }
    public void deleteEntry (int id) {
        instances.remove(Restaurant.findById(id));
    }

    public void update(String restaurantName, String neighborhood, String genre, String favoriteDish, int rating){
        this.favoriteDish= favoriteDish;
        this.neighborhood = neighborhood;
        this.rating = rating;
        this.genre = genre;
        this.restaurantName = restaurantName;
    }
    //GETTERS
    public String getRestaurantName() {
        return restaurantName;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getGenre() {
        return genre;
    }
    public String getFavoriteDish() {
        return favoriteDish;
    }
    public String getRating() {
        int numRating = rating;
        String starRating ="";
        for (int i = 0; i < numRating; i++) {
            starRating +="★";
        } return starRating;
    }
    public static ArrayList<Restaurant> getInstances() {
        return instances;
    }

    public int getId() {
        return id;
    }

}
