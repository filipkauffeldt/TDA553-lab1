package Lab1.vehicles;

import java.awt.Color;

import Lab1.truckextensions.Transportbed;

public class CarTransporter extends Truck {

    /**
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param nrWheels
     */

    private Transportbed transportBed;
    
    public CarTransporter(int nrDoors, double enginePower, Color color, String modelName,
            int nrWheels, int capacity, double radius) {
        super(nrDoors, enginePower, color, modelName, nrWheels);

        transportBed = new Transportbed(capacity, radius);
        setTrailer(transportBed);
    }

    public double speedFactor() {
        if (!trailer.allowDriving()) {
            return 0;
        } else {
            return getEnginePower() * 0.01;
        }
    }

    public void load(ILoadable loadObject) {
        transportBed.load(loadObject);
    }

    public void unload(ILoadable loadedObject) {
        transportBed.unload(loadedObject);
    }

}
