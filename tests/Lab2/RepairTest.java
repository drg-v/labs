package Lab2;

import Lab1.Chair;
import Lab1.Repair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class RepairTest {

    @Test
    void RepairChair_NotBroken_True(){
        Chair obj = new Chair();
        obj.isBroken = true;
        Repair.repairChair(obj);
        assertFalse(obj.getIsBroken());
    }

    @Test
    void RepairChairMock_NotBroken_True(){
        Chair myMock = mock(Chair.class);
        when(myMock.getIsBroken()).thenReturn(false);
        Repair.repairChair(myMock);
        assertFalse(myMock.getIsBroken());
        verify(myMock).getIsBroken();
    }
}
