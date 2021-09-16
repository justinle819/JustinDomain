package Entity;

import ValueObject.PigmentColor;

//Entities object can be mutable (ideally we want to separate mutable states with logic and calculations)
public class Paint {
    private double volume;
    private PigmentColor pigmentColor;

    public Paint(double volume, PigmentColor pigmentColor) {
        this.volume = volume;
        this.pigmentColor = pigmentColor;
    }

    public void mixIn(Paint other) {
        volume += other.getVolume(); // object gets changed here
        double ratio = other.getVolume() / volume;
        //delegates to PigmentColor class to do the mixing logic
        pigmentColor = pigmentColor.mixedWith(other.getColor(), ratio);
    }

    public double getVolume() {
        return volume;
    }

    public PigmentColor getColor() {
        return pigmentColor;
    }
}
