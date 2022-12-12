package Lab1;

import java.util.HashSet;
import java.util.Set;

import Lab1.vehicles.Vehicle;

public class CarModel {
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();

    public CarModel() {
    }

    public void addCar(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
