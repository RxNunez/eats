package Food;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class RestaurantTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void NewTestObjectGetsCorrectlyCreated_true() throws Exception {
        Restaurant testFood = helper();
        assertEquals(true, testFood instanceof Restaurant);
    }
    @Test
    public void clearAllRestaurants() throws Exception {
        Restaurant testFood = helper();
        Restaurant otherFood = new Restaurant("Tin Shed", "Northeast", "Brunch", "Egg scrambles", 5);
        Restaurant.clearAllRestaurants();
        assertEquals(0, Restaurant.getInstances().size());
    }


    public Restaurant helper(){
        return new Restaurant("Dar Salaam", "Northeast", "Middle Eastern", "Lunch Buffet", 5);
    }
}