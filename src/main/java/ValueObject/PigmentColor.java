package ValueObject;

public class PigmentColor {
    private int red;
    private int yellow;
    private int blue;

    public PigmentColor mixedWith(PigmentColor other, double ratio) {
        return this;
    }
}
