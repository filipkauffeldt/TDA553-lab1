package Lab1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

import Lab1.vehicles.Saab95;
import Lab1.vehicles.Scania;
import Lab1.vehicles.Vehicle;
import Lab1.vehicles.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    CarView carView;
    CarModel carModel;
    int gasAmount = 0;

    CarController(CarView carView, CarModel carModel) {
        this.carView = carView;
        this.carModel = carModel;
        createButtons();
    }

    private void createButtons() {
        JPanel gasPanel = carView.gasPanel;
        JPanel controlPanel = carView.controlPanel;
        carView.initComponents();

        JSpinner gasSpinner = new JSpinner();
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1);// step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        JButton gasButton = new JButton("Gas");
        JButton brakeButton = new JButton("Brake");
        JButton turboOnButton = new JButton("Saab Turbo on");
        JButton turboOffButton = new JButton("Saab Turbo off");
        JButton liftBedButton = new JButton("Scania Lift Bed");
        JButton lowerBedButton = new JButton("Lower Lift Bed");

        JButton startButton = new JButton("Start all cars");
        JButton stopButton = new JButton("Stop all cars");

        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasPanel.add(carView.gasLabel, BorderLayout.PAGE_START);

        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);

        startButton.setPreferredSize(new Dimension(carView.getX() / 5 - 15, 200));
        carView.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(carView.getX() / 5 - 15, 200));
        carView.add(stopButton);
    }

    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */

}
