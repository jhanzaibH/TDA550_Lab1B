import java.awt.*;

/**
 * A class of a car Volvo240.
 */
public class Volvo240 extends Car implements Transportable {

    /**
     * The trim factor
     */
    protected final static double trimFactor = 1.25;
    /**
     * Shows if the car is transported
     */
    protected boolean currentlyTransported;

    /**
     * Creates a car Volvo240
     */
    public Volvo240() {
        super(4,Color.black,100,"Volvo240");
        currentlyTransported = false;
        stopEngine();
    }

    /**
     * Returns trimFactor
     * @return double
     */
    public double getTrimFactor() {
        return trimFactor;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public boolean getCurrentlyTransported(){
        return currentlyTransported;
    }
    @Override
    public void setCurrentlyTransported(Boolean bool) {
        currentlyTransported = bool;
    }

}