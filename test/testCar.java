import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import static org.junit.Assert.*;

public class testCar {
    private Saab95 saab = new Saab95();
    @Test
    @Before
    public void testStartEngine(){
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(),0.0);
    }
    @Test
    public void testGetModelName(){
        assertEquals("Saab95", saab.getModelName());
    }

    @Test
    public void testGetNrDoors(){
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void testGetEnginePower(){
        assertEquals(125.0, saab.getEnginePower(), 0.0);
    }

    @Test
    public void testGetCurrentSpeed(){
        assertEquals(0.1, saab.getCurrentSpeed(),0.0);
    }

    @Test
    public void testGetColor(){
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    public void testSetColor(){
        saab.setColor(Color.green);
        assertEquals(Color.green, saab.getColor());
    }
    @Test
    public void testStopEngine(){
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(),0.0);
    }
    @Test
    public void testGas() {
        double startSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        assertEquals(startSpeed + saab.speedFactor() * 0.5, saab.getCurrentSpeed(),0.0);
    }
    @Test
    public void testBrake() {
        saab.gas(0.9);
        saab.brake(0.4);
        double decreasedSpeed = saab.getCurrentSpeed();

        saab.stopEngine();
        saab.startEngine();
        saab.gas(0.9);
        saab.brake(0.4);
        assertEquals(decreasedSpeed, saab.getCurrentSpeed(),0.0);
    }
    @Test
    public void testGetDirection(){
        assertEquals(0, saab.getDirection());
    }
    @Test
    public void testGetPosition(){
        saab.move();
        assertEquals(0.1,saab.getPosition()[0],0.0);
        assertEquals(0.0,saab.getPosition()[1],0.0);
    }
    @Test
    public void testMove(){
        saab.startEngine();
        saab.move();
        assertEquals(0.1, saab.getPosition()[0], 0.0);
        assertEquals(0.0, saab.getPosition()[1], 0.0);
        saab.turnLeft();
        saab.move();
        assertEquals(0.1,saab.getPosition()[0],0.0);
        assertEquals(0.1,saab.getPosition()[1],0.0);
        saab.turnLeft();
        saab.move();
        assertEquals(0.0,saab.getPosition()[0],0.0);
        assertEquals(0.1,saab.getPosition()[1],0.0);
        saab.turnLeft();
        saab.move();
        assertEquals(0.0,saab.getPosition()[0],0.0);
        assertEquals(0.0,saab.getPosition()[1],0.0);
    }
    @Test
    public void testTurnLeft(){
        saab.turnLeft();
        assertEquals(1, saab.getDirection());
        saab.turnRight();
    }
    @Test
    public void testTurnRight(){
        saab.turnRight();
        assertEquals(3, saab.getDirection());
        saab.turnLeft();
    }
}
