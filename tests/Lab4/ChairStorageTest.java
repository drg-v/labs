package Lab4;

import Lab1.Chair;
import Lab1.Manufacturer;
import Lab1.enumeration.ChairLegs;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ChairStorageTest {

    @Test
    public void getTotal4Legs_20_True() {
        ChairStorage storage = new ChairStorage();
        Manufacturer obj = new Manufacturer("Wood master");
        storage.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        storage.add(new Chair(10,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        storage.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        storage.add(new Chair(10,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        storage.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));

        assertEquals(storage.getTotal4Legs(), 20);
    }

    @Test
    public void getMaxPrice_150_True() {
        ChairStorage storage = new ChairStorage();
        Manufacturer obj = new Manufacturer("Wood master");
        storage.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        storage.add(new Chair(100,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        storage.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        storage.add(new Chair(150,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        storage.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));

        assertTrue(storage.getMaxPrice().isPresent());
        assertEquals(storage.getMaxPrice().get().getPrice(), 150);
    }

    @Test
    public void averagePrice_56_True() {
        ChairStorage storage = new ChairStorage();
        Manufacturer obj = new Manufacturer("Wood master");
        storage.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        storage.add(new Chair(100,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        storage.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        storage.add(new Chair(150,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        storage.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));

        assertTrue(storage.averagePrice().isPresent());
        assertEquals(storage.averagePrice().getAsDouble(), 56);
    }

    @Test
    public void checkConditionTest_True2False3_True() {
        Predicate<Chair> check = obj -> obj.getLegs().getNum() == 4;
        ChairStorage storage = new ChairStorage();
        Manufacturer obj = new Manufacturer("Wood master");
        storage.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        storage.add(new Chair(100,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        storage.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        storage.add(new Chair(150,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        storage.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));

        Map<Boolean, List<Chair>> obj_my = storage.checkCondition(check);
        assertEquals(obj_my.get(true).size(), 2);
        assertEquals(obj_my.get(false).size(), 3);
    }

    @Test
    public void mostPopularManufacturer_WoodMaster_True() {
        ChairStorage storage = new ChairStorage();
        Manufacturer obj = new Manufacturer("Wood master");
        storage.add(new Chair(10,40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj));
        storage.add(new Chair(100,45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj));
        storage.add(new Chair(10,50.0f, ChairLegs.THREE, 12.0f, 14.0f, 62.0f, 52.0f, "Third", obj));
        storage.add(new Chair(150,55.0f, ChairLegs.FOUR, 13.0f, 16.0f, 63.0f, 53.0f, "Fourth", obj));
        storage.add(new Chair(10,60.0f, ChairLegs.THREE, 14.0f, 18.0f, 64.0f, 54.0f, "Fifth", obj));

        assertEquals(storage.mostPopularManufacturer(), "Wood master");
    }
}
