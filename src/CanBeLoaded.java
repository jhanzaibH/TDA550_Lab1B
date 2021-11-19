
/**
 * Interface for classes for objects that can be loaded
 */
public interface CanBeLoaded {
    /**
     * Possible distance between loadable object and objects to be loaded
     */
    double loadingDistance = 10;
    /**
     * Load loadable thing
     */
    void load(Car car);

    /**
     * Unload loadable thing
     */
    void unload();
}
