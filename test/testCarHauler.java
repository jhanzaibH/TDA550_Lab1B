import org.junit.Test;

import static org.junit.Assert.*;

public class testCarHauler {
    private final CarHauler carHauler = new CarHauler();
    private final Saab95 saab95 = new Saab95();

    @Test
    public void testLoadingMethods(){
        carHauler.load(saab95);
        assertNull(carHauler.getLatestCar());

        carHauler.openPlatform();
        carHauler.load(saab95);
        carHauler.closePlatform();
        assertNotNull(carHauler.getLatestCar());

        carHauler.openPlatform();
        carHauler.unload();
        carHauler.closePlatform();

        assertNull(carHauler.getLatestCar());
    }

    @Test
    public void testPosition(){
        carHauler.setPosition(new double[]{1, 1});
        carHauler.openPlatform();
        carHauler.load(saab95);
        saab95.move();
        carHauler.closePlatform();

        assertEquals(carHauler.getPosition(), saab95.getPosition());
    }
    @Test
    public void testDistanceTo(){
        assertEquals(0, carHauler.distanceTo(saab95),0.1);
    }
    @Test
    public void testUnload(){
        carHauler.openPlatform();
        carHauler.load(saab95);
        carHauler.unload();
        assertEquals(-5.0, saab95.getPosition()[0], 0.1);
    }
}
