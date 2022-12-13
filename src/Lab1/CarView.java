package Lab1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Lab1.vehicles.Saab95;
import Lab1.vehicles.Scania;
import Lab1.vehicles.Vehicle;
import Lab1.vehicles.Volvo240;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller
 * in it's state.
 * It communicates with the Controller by calling methods of it when an action
 * fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements IUpdateable {
    private static final int X = 800;
    private static final int Y = 800;

    private CarModel carModel;

    private Map<Class<? extends Vehicle>, String> vehicleImageMap = new HashMap<Class<? extends Vehicle>, String>();

    DrawPanel drawPanel = new DrawPanel(X, Y - 240);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();

    private String frameName;
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    // Constructor
    public CarView(String frameName, CarModel carModel) {
        this.frameName = frameName;
        this.carModel = carModel;

        vehicleImageMap.put(Volvo240.class, "Volvo240.jpg");
        vehicleImageMap.put(Scania.class, "Scania.jpg");
        vehicleImageMap.put(Saab95.class, "Saab95.jpg");


        for (Vehicle v : carModel.getVehicles()) {
            drawPanel.addVehicle(v, vehicleImageMap.get(v.getClass()), (int) v.getPosX(), (int) v.getPosY());
        }
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and
    // components work
    public void createPanels() {
        gasPanel.setLayout(new BorderLayout());
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
    }

    public void initComponents() {
        this.setTitle(frameName);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update() {
        drawPanel.moveit();
        drawPanel.repaint();
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

}