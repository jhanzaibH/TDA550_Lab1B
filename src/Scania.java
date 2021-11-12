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
     * Creates a car of the type Saab95
     */
    public Scania(){
        super(2, Color.white,100,"Scania");
        platformDegree = 0;
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        // TODO: other speed factor?
        return getEnginePower()*0.01;
    }
    /**
     * Returns platfor degree
     */
    public double getPlatformDegree() {
        return platformDegree;
    }
    /**
     * Heightens the platform
     */
    public void heighten(Double degree){
        // TODO: is it -degree?
        if (platformDegree-degree >= 0) {
            platformDegree -= degree;
        }
    }
    /**
     * Lowers the platform
     */
    public void lower(Double degree){
        // TODO: is it +degree?
        if (platformDegree+degree <= 70) {
            platformDegree += degree;
        }
    }
    /**
     * Closes platform completely
     */
    public void closePlatform(){
        platformDegree = 0;
    }
    /**
     * Opens platform completely
     */
    public void openPlatform(){
        platformDegree = 70;
    }
}
