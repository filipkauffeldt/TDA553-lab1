package Lab1.truckextensions;

public class Dumptruck implements Trailer {
    private double currAngle = 0d;
    private double maxAngle = 70d;
    private double minAngle = 0d;
    private double posX;
    private double posY;
    private boolean rampIsMoving;

    public Dumptruck(double maxAngle, double minAngle) {
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
    }

    public double getCurrAngle() {
        return currAngle;
    }

    private void setCurrAngle(double currentAngle) {
        //TODO DO SOMETHING!!!
        if (currentAngle > maxAngle) {
            this.currAngle = maxAngle;

        } else if (currentAngle < minAngle) {
            this.currAngle = minAngle;

        } else {
            this.currAngle = currentAngle;
        }
        // TODO Add check if vehicle is moving in truck
    }

    public void updateCoordinates(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    public void raiseRamp(double amount) {
        
        setCurrAngle(getCurrAngle() + amount);
        rampIsMoving = !checkCurrAngle();
        

    }

    public void lowerRamp(double amount) {
        setCurrAngle(getCurrAngle() - amount);
        rampIsMoving = !checkCurrAngle();
    }

    private Boolean checkCurrAngle(){
        if(currAngle == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean allowDriving() {
        if(checkCurrAngle() && !rampIsMoving){
        return true;
        }
        else{
            return false;
        }
        
    }

    public double getMaxAngle() {
        return maxAngle;
    }

    public double getMinAngle() {
        return minAngle;
    }
}
