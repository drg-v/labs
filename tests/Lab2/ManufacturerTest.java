package Lab2;

import Lab1.Chair;
import Lab1.Manufacturer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ManufacturerTest {

    @Test
    void ConstructorSingleObject_CorrectInitialization_True(){
        Manufacturer obj = new Manufacturer("Name", new Chair());
        assertEquals(obj.getName(), "Name");
        assertEquals(obj.getModelsLength(), 1);
    }

    @Test
    void ConstructorSeveralObjects_CorrectInitialization_True(){
        Manufacturer obj = new Manufacturer("Name", new Chair(), new Chair(), new Chair());
        assertEquals(obj.getName(), "Name");
        assertEquals(obj.getModelsLength(), 3);
    }

    @Test
    void Equals_Equal_True(){
        Manufacturer obj = new Manufacturer("Name", new Chair(), new Chair(), new Chair());
        Manufacturer obj2 = new Manufacturer("Name", new Chair(), new Chair(), new Chair());
        assertTrue(obj.equals(obj2));
    }

    @Test
    void Equals_NotEqual_False(){
        Manufacturer obj = new Manufacturer("Name", new Chair(), new Chair(), new Chair());
        Manufacturer obj2 = new Manufacturer("NotThis", new Chair(), new Chair(), new Chair());
        assertFalse(obj.equals(obj2));
    }
}
