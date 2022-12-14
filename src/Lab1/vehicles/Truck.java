package Lab1.vehicles;

import java.awt.*;

import Lab1.truckextensions.Trailer;

public abstract class Truck extends Vehicle {
    int nrWheels;
    Trailer trailer;
    private double currentSpeed = 0; // Current speed
    private double enginePower; // Engine power

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int nrWheels) {
        super(nrDoors, enginePower, color, modelName);
        this.nrWheels = nrWheels;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public void removeTrailer() {
        this.trailer = null;
    }

    @Override
    public void startEngine() {
        if (trailer == null) {
            super.startEngine();
        } else {
            if (trailer.allowDriving()) {
                super.startEngine();
            } else {
                throw new IllegalStateException("Trailer is not allowed to drive");
            }
        }
    }

    private void setCurrentSpeed(double speed) {
        if (trailer == null) {
            if (speed > enginePower) {
                this.currentSpeed = enginePower;
            } else if (speed < 0d) {
                this.currentSpeed = 0d;
            } else {
                this.currentSpeed = speed;
            }
        } else {
            if (trailer.allowDriving()) {
                if (speed > enginePower) {
                    this.currentSpeed = enginePower;
                } else if (speed < 0d) {
                    this.currentSpeed = 0d;
                } else {
                    this.currentSpeed = speed;
                }
            } else {
                throw new IllegalStateException("Trailer is not allowed to drive");
            }
        }
    }

    @Override
    public void move() {
        super.move();
        trailer.updateCoordinates(getPosX(), getPosY());
    }

    public void raiseRamp(double ammount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot raise ramp while moving");
        }
        trailer.raiseRamp(ammount);
    }

    public void lowerRamp(double amount) {
        if (getCurrentSpeed() > 0) {
            throw new IllegalStateException("Cannot lower ramp while moving");
        }
        trailer.lowerRamp(amount);
    }
}
