package Lab1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

import Lab1.vehicles.Vehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, TODO: Generalize

    // TODO: Make this genereal for all cars
    Point volvoPoint = new Point(0, 0);
    Point saabPoint = new Point(0, 100);
    Point scaniaPoint = new Point(0, 200);
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    HashMap<Vehicle, Point> vehiclePointMap = new HashMap<>();
    HashMap<Vehicle, BufferedImage> vehicleImageMap = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to
            // pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle, String image, int x, int y) {
        vehiclePointMap.put(vehicle, new Point(x, y));
        switch (image) {
            case "Volvo240":
                vehicleImageMap.put(vehicle, volvoImage);
                break;
            case "Saab95":
                vehicleImageMap.put(vehicle, saabImage);
                break;
            case "Scania":
                vehicleImageMap.put(vehicle, scaniaImage);
                break;
            default:
                break;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : vehiclePointMap.keySet()) {
            g.drawImage(vehicleImageMap.get(vehicle), vehiclePointMap.get(vehicle).x, vehiclePointMap.get(vehicle).y,
                    null);
        }
    }

    public void moveit() {
        // Get position of the car and update the point in the map
        for (Vehicle vehicle : vehiclePointMap.keySet()) {
            vehiclePointMap.get(vehicle).x = (int) Math.round(vehicle.getPosX());
            vehiclePointMap.get(vehicle).y = (int) Math.round(vehicle.getPosY());
        }
    }
}
