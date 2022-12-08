package Lab1;

import javax.swing.*;

import java.awt.*;

import Lab1.vehicles.Saab95;
import Lab1.vehicles.Scania;
import Lab1.vehicles.Vehicle;
import Lab1.vehicles.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());

        cc.vehicles.add(new Saab95(Color.RED, "Saab95", true));

        cc.vehicles.add(new Scania(2, 200, 1, Color.GREEN, "Scania", 6));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        for(Vehicle vehicle : cc.vehicles)
        cc.frame.drawPanel.addVehicle(vehicle, vehicle.getModelName(), (int)vehicle.getPosX(), (int)vehicle.getPosY());

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.moveit();
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
}
