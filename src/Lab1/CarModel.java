package Lab1;

import java.util.HashSet;
import java.util.Set;

import Lab1.vehicles.Vehicle;

public class CarModel implements IUpdateable{
    private Set<Vehicle> vehicles = new HashSet<Vehicle>();


    public CarModel() {
    }

    public void addCar(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void gasAll(double ammount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(ammount);
        }
    }

    public void update() {
        moveAllVehicles();
    }

    private void moveAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            // System.out.println(vehicle.getModelName() + " X:" + vehicle.getPosX() + " Y:" + vehicle.getPosY());
        }
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    
}
