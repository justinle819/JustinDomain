package ValueObject;

// Pigment color is a value object, it consists of immutable (getters or queries only, no setters or commands)
// It is a great candidate for complex logic and calculations
public class PigmentColor {
    private int red;
    private int yellow;
    private int blue;

    public PigmentColor(int red, int yellow, int blue) {
        this.red =  red;
        this.yellow = yellow;
        this.blue = blue;
    }

    public PigmentColor mixedWith(PigmentColor other, double ratio) {
        //contains complex color-mixing logic ending with the creation if new PigmentColor object
        //creates new Pigment color where the state remain unchanged. Creating new object will ensure immutability
        return new PigmentColor(1,1,1);
    }
}
