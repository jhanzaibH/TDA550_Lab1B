/**
 * Interface for transporters
 */
public interface Transporter extends Loadable, Movable{
    /**
     * Possible objects to transport
     */
    Object[] possibleLoad = new Object[0];
    /**
     * Transport loaded objects
     */
    void transport();
}
