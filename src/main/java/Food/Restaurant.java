package Food;
import java.util.ArrayList;


public class Restaurant {
    private String restaurantName;
    private String neighborhood;
    private String genre;
    private String favoriteDish;
    private int rating;
    private static ArrayList<Restaurant> instances = new ArrayList<>();

    public Restaurant(String restaurantName, String neighborhood, String genre, String favoriteDish, int rating){
        this.favoriteDish= favoriteDish;
        this.neighborhood = neighborhood;
        this.rating = rating;
        this.genre = genre;
        this.restaurantName = restaurantName;
        instances.add(this);
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
    public int getRating() {
        return rating;
    }
    public static ArrayList<Restaurant> getInstances() {
        return instances;
    }

}
