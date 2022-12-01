package Lab1.vehicles;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.*;

import Lab1.vehicles.Vehicle.Direction;

public class CarTest {
    @Test
    public void direction_left_after_down() {
        assertEquals(Direction.LEFT, Direction.DOWN.next());
    }

    @Test
    public void direction_up_after_left() {
        assertEquals(Direction.UP, Direction.LEFT.next());
    }

    @Test
    public void direction_right_after_up() {
        assertEquals(Direction.RIGHT, Direction.UP.next());
    }

    @Test
    public void direction_down_after_right() {
        assertEquals(Direction.DOWN, Direction.RIGHT.next());
    }

    @Test
    public void direction_left_before_up() {
        assertEquals(Direction.LEFT, Direction.UP.prev());
    }

    @Test
    public void direction_up_before_right() {
        assertEquals(Direction.UP, Direction.RIGHT.prev());
    }

    @Test
    public void direction_right_before_down() {
        assertEquals(Direction.RIGHT, Direction.DOWN.prev());
    }

    @Test
    public void direction_down_before_left() {
        assertEquals(Direction.DOWN, Direction.LEFT.prev());
    }

    @Test
    public void gas_stays_within_expected_values() {
        Saab95 saab = new Saab95(4, 100, 0, Color.BLACK, "95", false);
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(2.0d);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(-1);
        });
    }

    @Test
    public void brake_stays_within_expected_values() {
        Saab95 saab = new Saab95(4, 100, 0, Color.BLACK, "95", false);
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(2.0d);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(-1);
        });
    }

    @Test
    public void engine_power_is_same_as_assigned() {
        double enginePower = 10;
        Saab95 saab = new Saab95(4, enginePower, 0, Color.BLACK, "95", false);
        assertEquals(enginePower, saab.getEnginePower());
    }

    @Test
    public void turning_four_times_left_returns_to_start() {
        Saab95 saab = new Saab95(4, 100, 0, Color.BLACK, "95", false);
        Direction initialDirection = saab.getDirection();
        for (int i = 0; i < 4; i++) {
            saab.turnLeft();
        }
        assertEquals(initialDirection, saab.getDirection());
    }

    @Test
    public void turning_four_times_right_returns_to_start() {
        Saab95 saab = new Saab95(4, 100, 0, Color.BLACK, "95", false);
        Direction initialDirection = saab.getDirection();
        for (int i = 0; i < 4; i++) {
            saab.turnRight();
        }
        assertEquals(initialDirection, saab.getDirection());
    }

    @Test
    public void braking_doesnt_make_the_car_reverse() {
        Saab95 saab = new Saab95(4, 100, 0, Color.BLACK, "95", false);
        for (int i = 0; i < 100; i++) {
            saab.brake(1);
        }
        assertEquals(true, 0 <= saab.getCurrentSpeed());
    }
}
