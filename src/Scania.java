import java.awt.*;
/**
 * Class for Scania cars
 */
public class Scania extends Car{
    /**
     * Degree that platform is lowered, between 0 and 70 degrees
     */
    protected double platformDegree;
    /**
     * Returns true if platform is closed
     */
    protected boolean platformClosed;
    /**
     * Creates a car of the type Saab95
     */
    public Scania(){
        super(2, Color.white,100,"Scania");
        platformDegree = 0;
        platformClosed = true;
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        // TODO: other speed factor?
        return getEnginePower()*0.01;
    }
    /**
     * Returns platform degree
     */
    public double getPlatformDegree() {
        return platformDegree;
    }
    /**
     * Heightens the platform
     */
    public void heighten(Double degree){
        if (platformDegree-degree >= 0) {
            platformDegree -= degree;
        }
        if (degree == 0) {
            platformClosed = true;
        }
    }
    /**
     * Lowers the platform
     */
    public void lower(Double degree){
        if (platformDegree+degree <= 70 && currentSpeed==0) {
            platformDegree += degree;
        }
        if (degree != 0) {
            platformClosed = false;
        }
    }
    /**
     * Closes platform completely
     */
    public void closePlatform(){
        platformDegree = 0;
        platformClosed = true;
    }
    /**
     * Opens platform completely
     */
    public void openPlatform(){
        if (currentSpeed == 0) {
            platformDegree = 70;
            platformClosed = false;
        }
    }
}
