import java.util.ArrayList;

public class ServiceStation<T extends Car>{ //TODO: implement CanBeLoaded
    private final int maxCarCapacity;
    private ArrayList<T> carsInStation;
    private int currentNumberOfCars;
    public ServiceStation(int maxCarCapacity){
        carsInStation = new ArrayList<>(maxCarCapacity);
        this.maxCarCapacity = maxCarCapacity;
        currentNumberOfCars = 0;
    }

    public void addCar(T carToLoad){ //TODO: change to load, override
        if(currentNumberOfCars<maxCarCapacity) {
            carsInStation.add(carToLoad);
            currentNumberOfCars++;
        }
    }
    //TODO
    public T removeCar(){
        if(currentNumberOfCars>0){
            return carsInStation.get(--currentNumberOfCars);
        }
        return null;
    }
}
