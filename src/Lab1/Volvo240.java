package Lab1;

import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        stopEngine();
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
