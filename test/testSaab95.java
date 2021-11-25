import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class testSaab95 {
    private final Saab95 saab = new Saab95();
    @Test
    @Before
    public void testSetTurboOn(){
        saab.setTurboOn();
        assertTrue(saab.getTurbo());
    }
    @Test
    public void testSaab95Constructor(){
        assertEquals("Saab95", saab.getModelName() );
    }
    @Test
    public void testSetTurboOff() {
        saab.setTurboOff();
        assertFalse(saab.getTurbo());
    }
    @Test
    public void testGetTurbo() {
        assertTrue(saab.getTurbo());

    }
    @Test
    public void testSpeedFactor() {
        assertEquals(saab.getEnginePower()*0.01*1.3, saab.speedFactor(),0.0);
    }
    @Test
    public void testGas(){
        double amount = 1;
        double speed = saab.getCurrentSpeed() + saab.speedFactor() * amount;
        saab.gas(amount);
        assertEquals(speed, saab.getCurrentSpeed(),0.0);
    }
}