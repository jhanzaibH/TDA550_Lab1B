import java.awt.*;
/**
 * A class of a car Saab95
 */
public class Saab95 extends Car implements Transportable{

    /**
     * Turbo
     */
    protected boolean turboOn;
    /**
     * Shows if the car is transported
     */
    protected boolean currentlyTransported;

    /**
     * Creates a car of the type Saab95
     */
    public Saab95(){
        super(2,Color.red,125,"Saab95");
        turboOn = false;
        currentlyTransported = false;
        stopEngine();
    }

    /**
     * Turns on turbo
     */
    public void setTurboOn(){
        turboOn = true;
    }
    /**
     * Turns off turbo off
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * Gives true if turbo in on
     * @return boolean
     */
    public boolean getTurbo(){
        return turboOn;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    
    // stuff from Transportable interface
    @Override
    public boolean getCurrentlyTransported(){
        return currentlyTransported;
    }
    @Override
    public void setCurrentlyTransported(Boolean bool){
        currentlyTransported = bool;
    }
}