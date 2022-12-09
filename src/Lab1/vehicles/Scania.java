package Lab1.vehicles;

import java.awt.*;

import Lab1.truckextensions.Dumptruck;

public class Scania extends Truck {

    private Dumptruck dumptruck;

    public Scania(
            int nrDoors,
            double enginePower,
            double currentSpeed, Color color,
            String modelName,
            int nrWheels) {
        super(nrDoors, enginePower, color, modelName, nrWheels);
        stopEngine();
        dumptruck = new Dumptruck(70, 0);
        setTrailer(dumptruck);
    }

    @Override
    public double speedFactor() {
        if (!trailer.allowDriving()) {
            return 0;
        } else {
            return getEnginePower() * 0.01;
        }
    }

    public void raiseRamp(double amount) {
        trailer.raiseRamp(amount);
    }

    public void lowerRamp(double amount) {
        trailer.lowerRamp(amount);
    }
}
