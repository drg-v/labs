package Lab2;

import Lab1.Seat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SeatTest {

    @Test
    void DefaultConstructor_CorrectInitialization_True(){
        Seat obj = new Seat();
        assertEquals(obj.getWidth(), 10);
        assertEquals(obj.getHeight(), 10);
    }

    @Test
    void Constructor_CorrectInitialization_True(){
        Seat obj = new Seat(20, 30);
        assertEquals(obj.getWidth(), 30);
        assertEquals(obj.getHeight(), 20);
    }
}
