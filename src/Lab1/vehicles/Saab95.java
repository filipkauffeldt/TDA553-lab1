package Lab1.vehicles;

import java.awt.*;

public class Saab95 extends Car implements ITurboable {
    private Boolean turboOn;

    public Saab95(Color color, String modelName,
            boolean turboOn) {
        super(2, 125, color, modelName);
        this.turboOn = turboOn;
        setPosY(100);
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public Boolean getTurboOn() {
        return turboOn;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
