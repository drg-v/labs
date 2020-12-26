package Lab2;

import Lab1.Chair;
import Lab1.Repair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;


public class RepairIT {

    @Test
    void RepairChairMock_NotBroken_True(){
        Chair myMock = mock(Chair.class);
        when(myMock.getIsBroken()).thenReturn(false);
        Repair.repairChair(myMock);
        assertFalse(myMock.getIsBroken());
        verify(myMock).getIsBroken();
    }
}

