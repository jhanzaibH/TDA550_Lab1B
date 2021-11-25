import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testScania {
    private Scania scania = new Scania();
    @Test
    @Before
    public void testOpenPlatform(){
        scania.openPlatform();
        assertEquals(70,scania.getPlatformDegree(), 0.1);
    }
    @Test
    public void testSaab95Constructor(){
        assertEquals("Scania", scania.getModelName() );
    }
    @Test
    public void testSpeedFactor(){
        assertEquals(scania.getEnginePower()*0.01, scania.speedFactor(), 0.1);
    }
    @Test
    public void testHeighten(){
        scania.heighten(30.0);
        assertEquals(40.0,scania.getPlatformDegree(),0.1);
    }
    @Test
    public void testLower(){
        scania.closePlatform();
        scania.lower(30.0);
        assertEquals(30,scania.getPlatformDegree(),0.1);
    }
    @Test
    public void testClosePlatform(){
        scania.closePlatform();
        assertEquals(0,scania.getPlatformDegree(), 0.1);
    }
    @Test
    public void testMove(){
        scania.closePlatform();
        scania.startEngine();
        scania.move();
        assertEquals(0,scania.getPosition()[0], 0.1);
    }
}