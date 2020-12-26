package Lab4;

import Lab1.Chair;
import Lab1.Manufacturer;
import Lab1.enumeration.ChairLegs;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChairStorageIT {

    @Test
    public void getTotal4Legs_10_True() {
        ChairStorage storage = new ChairStorage();

        ChairStorage spyStorage = Mockito.spy(storage);
        when(spyStorage.getTotal4Legs()).thenReturn(10.0);

        Manufacturer obj = new Manufacturer("Wood master");
        Chair chairOne = new Chair(10, 40.0f, ChairLegs.THREE, 10.0f, 10.0f, 60.0f, 50.0f, "First", obj);
        Chair chairTwo = new Chair(10, 45.0f, ChairLegs.FOUR, 11.0f, 12.0f, 61.0f, 51.0f, "Second", obj);
        spyStorage.add(chairOne);
        spyStorage.add(chairTwo);

        Mockito.verify(spyStorage).add(chairOne);
        Mockito.verify(spyStorage).add(chairTwo);
        assertEquals(spyStorage.getTotal4Legs(), 10.0);
    }
}