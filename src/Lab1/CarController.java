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
    double gasAmount = 5d;

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    private double gasAmmount = 0;

    CarController(CarView carView, CarModel carModel) {
        this.carView = carView;
        this.carModel = carModel;
        createContainersInView();
        addComponentsToPanels();
        initializeView();
    }

    private void createContainersInView() {
        carView.createPanels();
    }

    private void addComponentsToPanels() {
        JSpinner gasSpinner = new JSpinner();
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1);// step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmmount = (Integer) ((JSpinner) e.getSource()).getValue();
            }
        });
        carView.gasPanel.add(carView.gasLabel, BorderLayout.PAGE_START);
        carView.gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        carView.controlPanel.add(gasButton, 0);
        carView.controlPanel.add(turboOnButton, 1);
        carView.controlPanel.add(liftBedButton, 2);
        carView.controlPanel.add(brakeButton, 3);
        carView.controlPanel.add(turboOffButton, 4);
        carView.controlPanel.add(lowerBedButton, 5);

        // gasSpinner.addChangeListener(new ChangeListener() {
        //     @Override
        //     public void stateChanged(ChangeEvent e) {
        //         gasAmount = 0;
        //         var val = ((JSpinner)e.getSource()).getValue();
                
                 
        //         gasAmmount = Double.parseDouble(val.toString());
        //         System.out.println("gasAmmount: " + gasAmount);
        //         System.out.println(val);
        //     }
        // });

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.gasAll(gasAmmount/100d);
            }
        });

    }

    private void initializeView() {
        carView.add(carView.drawPanel);
        carView.add(carView.gasPanel);
        carView.add(carView.controlPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(carView.getX() / 5 - 15, 200));
        carView.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(carView.getX() / 5 - 15, 200));
        carView.add(stopButton);
        carView.initComponents();
    }

}
