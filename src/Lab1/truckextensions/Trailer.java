package Lab1.truckextensions;

public interface Trailer {
    public void updateCoordinates(double x, double y);

    public Boolean allowDriving();

    public void raiseRamp(double amount);

    public void lowerRamp(double amount);

}
