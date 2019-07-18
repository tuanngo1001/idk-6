package idk6.csexperience.business;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class GameServicesTest {
    @Test
    public void testLoad(){
        System.out.println("Starting testLoad\n");
        GameServices mockGameServices = mock(GameServices.class);
        mockGameServices.load("NOBODY");
        verify(mockGameServices).load("NOBODY");
        when(mockGameServices.load("NOBODY")).thenReturn(false);
        System.out.println("Finishing testLoad\n");
    }
    @Test
    public void testSave(){
        System.out.println("Starting testSave\n");
        GameServices mockGameServices = mock(GameServices.class);
        mockGameServices.save();
        verify(mockGameServices).save();
        when(mockGameServices.save()).thenReturn(true);
        System.out.println("Finishing testSave\n");
    }

}
