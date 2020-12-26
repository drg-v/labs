package Lab2;

import Lab1.Chair;
import Lab1.exception.BrokenChair;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChairIT {

    @Test
    void showChairMock_BrokenChair_ExceptionThrown(){
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
