import java.awt.*;
/**
 * This is the abstract class inherited by different car models.
 *
 * @author Alvin
 * @author Jhanzaib
 * @author Simon
 */
public abstract class Car implements Movable{ // the class can be abstract as objects of this class is not created
    // By using an abstract class instead of an interface the instance variables can also be inherited
    /** Number of doors of the car */
    private final int nrDoors; // Number of doors on the car
    /** Engine power of the car */
    private final double enginePower; // Engine power of the car
    /** Current speed of tha car */
    protected double currentSpeed; // The current speed of the car
    /** Color of the car */
    private Color color; // Color of the car
    /** Model name of the car */
    private final String modelName; // The car model name
    /** Direction of the car */
    private int direction = 0; // 0: positive x direction, 1: positive y direction, 2: negative x direction, 3: negative y direction
    /** Position of the car */
    private double[] position = {0,0};

    /** Length of the car */
    private final int length = 10;
    /** Width of the car */
    private final int width = 5;

    /**
     * Creates a car with specified parameters
     * @param nrDoors number of doors
     * @param color color of the car
     * @param enginePower enginePower of the car
     * @param modelName name of the car
     */
    public Car(int nrDoors, Color color, int enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }

    /**
     * Returns the modelname of the car
     * @return String
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * Get number of doors
     * @return int
     */
    public int getNrDoors(){
        return nrDoors;
    }
    /**
     * Returns the engine power
     * @return double
     */
    public double getEnginePower(){
        return enginePower;
    }
    /**
     * Returns the current speed of the car
     * @return double
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    /**
     * Returns the color of the car
     * @return Color
     */
    public Color getColor(){
        return color;
    }
    /**
     * Sets the color of the car
     * @param clr new color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }
    /**
     * Starts the engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }
    /**
     * Sets the current speed to 0
     */
    public void stopEngine(){ currentSpeed = 0; }
    /**
     * Speed factor
     * @return double
     */
    protected abstract double speedFactor();
    // TODO probably change this comment
    /**
     * Increments speed
     * @param amount is speed to be increased
     */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Uses the method incrementSpeed
     * @param amount increase speed by amount
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decrements speed
     * @param amount the speed is to be decreased
     */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    /**
     * Decrements speed
     * @param amount decrements the speed with amount
     */
    public void brake(double amount){
        if(amount>=0 && amount<=1){
            decrementSpeed(amount);
        }
    }

    /**
     * Gives current direction
     * @return int
     */
    public int getDirection(){
        return direction;
    }

    /**
     * Gives current position
     * @return double[]
     */
    public double[] getPosition(){
        return position;
    }

    @Override
    public void move(){
        switch (direction) {
            case 0 -> position[0] += getCurrentSpeed();
            case 1 -> position[1] += getCurrentSpeed();
            case 2 -> position[0] -= getCurrentSpeed();
            case 3 -> position[1] -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        direction += 1;
        direction %= 4;
    }

    @Override
    public void turnRight() {
        direction -= 1;
        if (direction < 0){ direction += 4; }
    }
}