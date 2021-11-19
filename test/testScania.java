import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testScania {
    Scania scania = new Scania();
    @Test
    public void testSaab95Constructor(){
        assertEquals("Scania", scania.getModelName() );
    }
    @Test
    public void testSpeedFactor(){
        assertEquals(scania.getEnginePower()*0.01, scania.speedFactor());
    }
    @Test
    public void testHeighten(){
        scania.openPlatform();
        scania.heighten(30.0);
        assertEquals(40.0,scania.getPlatformDegree(),0.1);
    }
    @Test
    public void testLower(){
        scania.lower(30.0);
        assertEquals(30,scania.getPlatformDegree());
    }
    @Test
    public void testClosePlatform(){
        scania.openPlatform();
        scania.closePlatform();
        assertEquals(0,scania.getPlatformDegree());
    }
    @Test
    public void testOpenPlatform(){
        scania.openPlatform();
        assertEquals(70,scania.getPlatformDegree());
    }
    @Test
    public void testMove(){
        scania.openPlatform();
        scania.startEngine();
        scania.move();
        assertEquals(new double[]{0,0},scania.getPlatformDegree());
    }
}