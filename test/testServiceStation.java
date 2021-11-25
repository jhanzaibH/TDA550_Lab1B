import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class testServiceStation {
    private final Saab95 saab = new Saab95();
    private final ServiceStation<Car> serviceStation = new ServiceStation<>(10,1,0);
    @Test
    public void testAddAndRemoveCar(){
        serviceStation.addCar(saab);
        Car saabRemoved = serviceStation.removeLastCar();
        assertNotEquals(null, saabRemoved);
    }
    @Test
    public void testGetPosition(){
        double[] position = serviceStation.getPosition();
        assertEquals(1.0,position[0],0.1);

    }
}
