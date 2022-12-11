package Lab1;

import java.awt.Color;
import java.util.ArrayList;

import Lab1.vehicles.Saab95;
import Lab1.vehicles.Scania;
import Lab1.vehicles.Vehicle;
import Lab1.vehicles.Volvo240;

public class Program {
    public static void main(String[] args) {
        var vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Volvo240());
        vehicles.add(new Saab95(Color.BLACK, "Saab95", true));
        vehicles.add(new Scania(2, 125, 0, Color.BLACK, "Scania", 6));
        var controller = new CarController(vehicles);

        while(true) {
            
        }
    }
}
