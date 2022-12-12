package Lab1;

import java.awt.Color;
import java.util.ArrayList;

import Lab1.vehicles.Saab95;
import Lab1.vehicles.Scania;
import Lab1.vehicles.Vehicle;
import Lab1.vehicles.Volvo240;

public class Program {
    public static void main(String[] args) {
        CarModel carModel = new CarModel();
        carModel.addCar(new Volvo240());
        carModel.addCar(new Saab95(Color.BLACK, "Saab95", true));
        carModel.addCar(new Scania(2, 125, 0, Color.BLACK, "Scania", 6));
        CarView carView = new CarView("CarSim 1.0", carModel);
        CarController controller = new CarController(carView, carModel);


        ArrayList<IUpdateable> updateableList = new ArrayList<IUpdateable>();
        updateableList.add(carModel);
        updateableList.add(carView);
        TimerListener timerListener = new TimerListener(updateableList);

        timerListener.start();
    }
}
