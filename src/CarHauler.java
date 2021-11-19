import java.awt.*;
import java.util.Stack;


/**
 * Class for car transporting cars
 */
public class CarHauler extends Car implements CanBeLoaded {
    /**
     * Use Scania class for using common methods
     */
    private Scania scania;
    /**
     * All loaded cars
     */
    private Stack<Car> loadedCars;
    /**
     * Maximum size of loaded cars
     */
    private int maxCarSize;
    /**
     * Creates a car of the type Saab95
     */
    public CarHauler(){
        super(2, Color.white,100,"Scania");
        scania = new Scania();
        scania.closePlatform();
        loadedCars = new Stack<>();
        stopEngine();
        size = 10000;
        maxCarSize = 1500;
    }
    @Override
    public void startEngine(){
        scania.startEngine();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower()*0.01;
    }

    public Car getLatestCar(){
        return (!loadedCars.isEmpty()) ? loadedCars.peek() : null;
    }

    /**
     * If input is transportable car, load it on CarHauler
     */
    public void load(Car car){
        if (car.getSize()>maxCarSize || car.getCurrentlyLoaded()){
            System.out.println("The car is too heavy or is loaded somewhere else");
            return;
        }
        if (distanceTo(car) < loadingDistance && !scania.platformClosed && car.size <= maxCarSize){
            loadedCars.add(car);
            car.setPosition(this.getPosition());
            car.setCurrentlyLoaded(true);
        }
        else {
            System.out.println("Car too far away, or platform closed");
        }
    }
    /**
     * Distance between Car Hauler and a car
     */
    protected double distanceTo(Car car){
        return Math.sqrt(Math.pow(this.getPosition()[0] - car.getPosition()[0],2) + Math.pow(this.getPosition()[1] - car.getPosition()[1] ,2));
    }

    @Override
    public void unload(){
        int distance = 5;
        if (!scania.platformClosed && !loadedCars.isEmpty()){
            switch (scania.getDirection()) {
                case 0 -> loadedCars.peek().setPosition(new double[]{scania.getPosition()[0] - distance, scania.getPosition()[1]});
                case 1 -> loadedCars.peek().setPosition(new double[]{scania.getPosition()[0], scania.getPosition()[1] - distance});
                case 2 -> loadedCars.peek().setPosition(new double[]{scania.getPosition()[0] + distance, scania.getPosition()[1]});
                case 3 -> loadedCars.peek().setPosition(new double[]{scania.getPosition()[0], scania.getPosition()[1] + distance});
            }
            loadedCars.peek().setCurrentlyLoaded(false);
            loadedCars.pop();
        }
        else {
            System.out.println("Platform is closed or there are no cars to unload");
        }
    }
    /**
     * Opens platform completely
     */
    public void openPlatform(){
        scania.openPlatform();
    }
    /**
     * Closes platform completely
     */
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