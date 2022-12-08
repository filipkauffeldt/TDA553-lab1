package Lab1.vehicles;

import java.awt.*;

public abstract class Vehicle implements IMovable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power
    private double currentSpeed = 0; // Current speed
    private Color color; // Color of the car
    private String modelName; // Name of the model
    private double posX;
    private double posY;

    private Direction currentDirection;

    protected Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.posX = 0;
        this.posY = 0;
        this.currentDirection = Direction.RIGHT;
    }

    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN;

        private static final Direction[] vals = values();

        // Returns the direction after the current one, and loops back to the first in
        // case it overflows
        public Direction next() {
            return vals[(Math.floorMod(this.ordinal() + 1, vals.length))];
        }

        // Returns the direction before the current one and loops to the last one in
        // case it underflows
        /*
         * Note: Math.floorMod is used because Java built in modulo operator can
         * return negative values
         */
        public Direction prev() {
            return vals[(Math.floorMod(this.ordinal() - 1, vals.length))];
        }
    }

    public abstract double speedFactor();

    public void gas(double amount) {
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        incrementSpeed(amount);
    }

    // public abstract void brake(double amount);
    public void brake(double amount) {
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        decrementSpeed(amount);
    }

    protected void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed > enginePower) {
            this.currentSpeed = enginePower;
        } else if (currentSpeed < 0d) {
            this.currentSpeed = 0d;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public Color getColor() {
        return color;
    }

    // Protected?
    public void setColor(Color color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public Direction getDirection() {
        return currentDirection;

    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    protected void setPosX(double posX) {
        this.posX = posX;
    }

    protected void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public void move() {
        if (currentDirection == Direction.LEFT) {
            posX -= getCurrentSpeed();
        } else if (currentDirection == Direction.RIGHT) {
            posX += getCurrentSpeed();
        } else if (currentDirection == Direction.UP) {
            posY += getCurrentSpeed();
        } else if (currentDirection == Direction.DOWN) {
            posY -= getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft() {
        currentDirection = currentDirection.prev();
    }

    @Override
    public void turnRight() {
        currentDirection = currentDirection.next();
    }

    public void moveToLoader(ILoadable loadable) {
        posX = loadable.getPosX();
        posY = loadable.getPosY();
    }

}
