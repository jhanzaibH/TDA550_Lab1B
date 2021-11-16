
import java.awt.*;
import java.util.Stack;


/**
 * Class for car transporting cars
 */
public class CarHauler extends Car implements Transporter, CanBeLoaded {
    /**
     * Use Scania class for using common methods
     */
    private Scania scania;
    /**
     * All loaded cars
     */
    private Stack<Car> loadedCars;
    /**
     * Creates a car of the type Saab95
     */
    public CarHauler(){
        super(2, Color.white,100,"Scania");
        scania = new Scania();
        scania.closePlatform();
        loadedCars = new Stack<>();
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        // TODO: other speed factor?
        return getEnginePower()*0.01;
    }

    @Override
    public void transport(){

    }


    /**
     * If input is transportable car, load it on CarHauler
     */
    // TODO: Check if the car or carHauler is moving. Change the interface
    @Override
    public <T extends Transportable> void load(T car){
        if (distanceTo((Car)car) < loadingDistance && !scania.platformClosed){
            loadedCars.add((Car) car);
            ((Car)car).setPosition(this.getPosition());
        }
        else {
            //TODO: Change later
            System.out.println("Car too far away");
        }
    }
    /**
     * Distance between Car Hauler and a car
     */
    private double distanceTo(Car car){
        return Math.sqrt(Math.pow(this.getPosition()[0] - car.getPosition()[0],2) + Math.pow(this.getPosition()[1] - car.getPosition()[1] ,2));
    }

    // TODO: Check if the car or carhauler is moving
    @Override
    public void unload(){
        if (!scania.platformClosed && !loadedCars.isEmpty()){ loadedCars.pop(); }
    }
    public void openPlatform(){
        scania.openPlatform();
    }
    public void closePlatform(){
        scania.closePlatform();
    }

    @Override
    public void move() {
        if (scania.platformClosed) {
            scania.move();
            for (Car car : loadedCars) {
                car.setPosition(this.getPosition());
            }
        }
    }

}
