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
    public void startEngine(){
        if (platformClosed) { currentSpeed = 0.1; }
    }
    @Override
    protected double speedFactor() {
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
        if (degree < 0){return;} // makes it impossible to heighten degree negatively
        if (platformDegree-degree >= 0 && currentSpeed==0) {
            platformDegree -= degree;
        } else { platformDegree = 0; }
        if (degree == 0) {
            platformClosed = true;
        }
    }
    /**
     * Lowers the platform
     */
    public void lower(Double degree){
        if (degree < 0){return;} // makes it impossible to lower degree negatively
        if (platformDegree+degree <= 70 && currentSpeed==0) {
            platformDegree += degree;
        } else { platformDegree = 70; }
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

    /**
     * Moves the car if the platform is closed
     */
    @Override
    public void move(){
        if(platformClosed){
            super.move();
        }
    }
}
