import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testVolvo240 {
    Volvo240 volvo = new Volvo240();

    @Test
    public void testConstructor(){
        assertEquals("Volvo240", volvo.getModelName());
    }

    @Test
    public void TestSpeedFactor(){
        assertEquals(volvo.getEnginePower() * 0.01 * volvo.getTrimFactor(), volvo.speedFactor(),0.0);
    }

    @Test
    public void TestGetTrimFactor(){
        assertEquals(volvo.getTrimFactor(),1.25,0.0);
    }
}
