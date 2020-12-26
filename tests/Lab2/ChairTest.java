package Lab2;

import Lab1.Chair;
import Lab1.Manufacturer;
import Lab1.enumeration.ChairLegs;
import Lab1.exception.BrokenChair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChairTest {

    @Test
    void Constructor_CorrectInitialization_True(){
        Manufacturer producer = new Manufacturer("Name", new Chair());

        Chair obj = new Chair(10,10, ChairLegs.FOUR, 10, 10, 10, 10, "Name", producer);
        assertEquals(obj.getName(), "Name");
        assertEquals(obj.getFrame().getHeight(), 10);
        assertEquals(obj.getFrame().getWidth(), 10);
        assertEquals(obj.getFrame().getLength(), 10);
        assertEquals(obj.getSitting().getHeight(), 10);
        assertEquals(obj.getSitting().getWidth(), 10);
        assertEquals(obj.getNum(), ChairLegs.FOUR);
        assertEquals(obj.getProducer(), producer);
    }

    @Test
    void showChair_BrokenChair_ExceptionThrown(){
        Manufacturer producer = new Manufacturer("Name", new Chair());
        Chair obj = new Chair(10,10, ChairLegs.FOUR, 10, 10, 10, 10, "Name", producer);
        obj.isBroken();
        try {
            obj.showChair();
        } catch (BrokenChair brokenChair) {
            assertEquals(brokenChair.getMessage(), obj.getName() + " is broken");
        }

    }

    @Test
    void showChairMock_BrokenChair_ExceptionThrown_IT(){
        Chair myMock = mock(Chair.class);
        when(myMock.getName()).thenReturn("Name");
        try {
            doThrow(new BrokenChair("Name is broken")).when(myMock).showChair();
            myMock.showChair();
        } catch (BrokenChair brokenChair) {
            assertEquals(brokenChair.getMessage(), myMock.getName() + " is broken");
        }
        verify(myMock).getName();
        try {
            verify(myMock).showChair();
        } catch (BrokenChair brokenChair) {
            System.out.println(brokenChair.getMessage());
        }
    }

}
