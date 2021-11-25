import java.awt.*;

/**
 * A class of a car Volvo240.
 */
public class Volvo240 extends Car {
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
        setCurrentlyLoaded(false);
        stopEngine();
        setSize(1000);
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
}