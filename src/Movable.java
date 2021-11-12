/**
 * Gives the object of implementing class the ability to move
 */
public interface Movable {
    /**
     * Move the car according to current speed
     */
    void move();
    /**
     * Turn left
     */
    void turnLeft();
    /**
     * Turn right
     */
    void turnRight();
}
