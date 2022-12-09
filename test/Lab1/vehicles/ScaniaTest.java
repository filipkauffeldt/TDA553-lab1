package Lab1.vehicles;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.*;

public class ScaniaTest {
    @Test
    public void raising_platform_should_not_be_more_than_maxAngle() {
        Scania scania = new Scania(2, 100, 0, Color.GREEN, "Scania", 8);
        scania.trailer.raiseRamp(100);
        assertEquals(scania.getMaxAngle(), scania.getCurrAngle());

    }

    @Test
    public void lowering_platform_should_not_be_more_than_lowestAngle() {
        Scania scania = new Scania(2, 100, 0, Color.GREEN, "Scania", 0);
        scania.trailer.lowerRamp(100);
        assertEquals(scania.getMinAngle(), scania.getCurrAngle());
    }

    @Test
    public void currentSpeed_should_be_0_if_platformAngle_is_not_0() {
        Scania scania = new Scania(2, 100, 0, Color.GREEN, "Scania", 0);
        scania.trailer.raiseRamp(50);
        assertEquals(0, scania.getCurrentSpeed());
    }

    @Test
    public void scania_cant_raise_platform_while_driving() {
        Scania scania = new Scania(2, 100, 0, Color.GREEN, "Scania", 0);
        scania.trailer.raiseRamp(100);
        assertThrows(IllegalStateException.class, () -> {
            scania.startEngine();
        });
    }
}
