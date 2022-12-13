package Lab1.vehicles;

import java.awt.*;

public class Volvo240 extends Car implements ITrimmable {

    private double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    public double getTrimFactor() {
        return trimFactor;
    }

}
