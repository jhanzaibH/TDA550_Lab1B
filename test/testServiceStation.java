import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class testServiceStation {
    Saab95 saab = new Saab95();
    Saab95 saab95 = new Saab95();
    ServiceStation<Car> serviceStation = new ServiceStation<>(10,0,0);
    @Test
    public void testAddAndRemoveCar(){
        serviceStation.addCar(saab);
        Car saabRemoved = serviceStation.removeLastCar();
        assertNotEquals(null, saabRemoved);
    }
    @Test
    public void testGetPosition(){
        ServiceStation<Car> serviceStation = new ServiceStation<>(10, 4.0,2.0);
        double[] position = serviceStation.getPosition();
        assertEquals(4.0,position[0],0.1);

    }
}
