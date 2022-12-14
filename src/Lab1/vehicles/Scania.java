package Lab1.vehicles;

import java.awt.*;

import Lab1.truckextensions.Dumptruck;

public class Scania extends Truck {

    public Scania(
            int nrDoors,
            double enginePower,
            double currentSpeed, Color color,
            String modelName,
            int nrWheels) {
        super(nrDoors, enginePower, color, modelName, nrWheels);
        stopEngine();
        this.trailer = new Dumptruck(70, 0);
        setPosY(200);
    }

    @Override
    public double speedFactor() {
        if (!trailer.allowDriving()) {
            return 0;
        } else {
            return getEnginePower() * 0.01;
        }
    }

    public void raiseRamp(double ammount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot raise ramp while moving");
        }
        trailer.raiseRamp(ammount);
    }

    public void lowerRamp(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot lower ramp while moving");
        }
        trailer.lowerRamp(amount);
    }
}
