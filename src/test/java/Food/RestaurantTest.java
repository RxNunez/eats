package Food;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class RestaurantTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Restaurant.clearAllRestaurants();
    }
    @Test
    public void NewTestObjectGetsCorrectlyCreated_true() throws Exception {
        Restaurant testFood = helper();
        assertEquals(true, testFood!=null );
    }
    @Test
    public void clearAllRestaurants() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        Restaurant.clearAllRestaurants();
        assertEquals(0, Restaurant.getInstances().size());
    }
    @Test
    public void Restaurant_createsAUniqueId() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        assertEquals(2, otherFood.getId());
    }
    @Test
    public void Restaurant_findbyId() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        assertEquals(1, Restaurant.findById(testFood.getId()).getId());
        assertEquals("Tin Shed", Restaurant.findById(otherFood.getId()).getRestaurantName());
    }
    @Test
    public void Restaurant_removeSpecificEntryById() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        testFood.deleteEntry(1);
        assertEquals(1, Restaurant.getInstances().size());
        assertEquals(Restaurant.getInstances().get(0).getId(), 2);
    }
    @Test
    public void Restaurant_updateSpecificEntry() throws Exception {
        Restaurant testFood = helper();
        testFood.update("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        assertEquals("Brunch", testFood.getGenre());
    }

    @Test
    public void searchByNeighborhood() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        Restaurant thirdFood = helper();
        ArrayList test = Restaurant.searchByNeighborhood("Downtown");
        assertEquals(2, test.size());
    }

    @Test
    public void clearingList() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        Restaurant thirdFood = helper();
        ArrayList test = Restaurant.getGenres();
        assertEquals(2, test.size());
    }

    public Restaurant helper(){
        return new Restaurant("DarSalam", "Downtown", "Middle Eastern", "Lunch Buffet", 5);
    }
}