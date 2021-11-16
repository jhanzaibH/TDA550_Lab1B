/**
 * Interface for transportable objects
 */
public interface Transportable{
    /**
     * Return true if object loaded on transporter
     */
    boolean getCurrentlyTransported();
    /**
     * Load/unload
     */
    void setCurrentlyTransported(Boolean bool);
}
