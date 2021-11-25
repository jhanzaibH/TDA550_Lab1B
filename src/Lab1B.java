import java.util.ArrayList;
import java.util.Arrays;
/**
 * The class Lab1A
 */
public class Lab1B {
    /**
     * An arrayList of Car
     */
    private static ArrayList<Car> carArrayList;
    /**
     * The main method
     * @param args is not used
     */
    public static void main(String[] args){

        carArrayList = new ArrayList<>(10);
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        CarHauler carHauler = new CarHauler();
        Scania scania = new Scania();

        volvo240.startEngine();
        saab95.startEngine();
        carHauler.startEngine();
        scania.startEngine();

        carHauler.openPlatform();
        carHauler.load(saab95);
        carHauler.unload();
        carHauler.closePlatform();

        saab95.move();
        System.out.println(Arrays.toString(saab95.getPosition()));

        ServiceStation<Saab95> serviceStation = new ServiceStation<>(5,1,1);
        serviceStation.addCar(saab95);
        serviceStation.printCars();
        System.out.println(Arrays.toString(saab95.getPosition()));

    }
}