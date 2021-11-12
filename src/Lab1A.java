import javax.swing.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * The class Lab1A
 */
public class Lab1A {
    /**
     * An arrayList of Car
     */
    public static ArrayList<Car> carArrayList;
    /**
     * The main method
     * @param args is not used
     */
    public static void main(String[] args){

        carArrayList = new ArrayList<>(10);
        Car c1 = new Volvo240();
        carArrayList.add(c1);

        c1.startEngine();
        System.out.println(Arrays.toString(c1.getPosition()));
        c1.move();
        System.out.println(Arrays.toString(c1.getPosition()));
        c1.turnLeft();
        System.out.println(c1.getDirection());
        c1.turnRight();
        System.out.println(c1.getDirection());
        c1.turnRight();
        System.out.println(c1.getDirection());
        c1.turnRight();
        System.out.println(c1.getDirection());
        c1.turnRight();
        System.out.println(c1.getDirection());
        c1.move();
        System.out.println(Arrays.toString(c1.getPosition()));
    }
}