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
}
