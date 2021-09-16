import Entity.MixedPaint;
import Entity.StockPaint;
import ValueObject.PigmentColor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MixPaintTest {

    // test for class invariant after issue command mixIn
    @Test
    void testMixingVolume()  {
        PigmentColor yellow = new PigmentColor(0,50,0);
        PigmentColor blue = new PigmentColor(0,0,50);

        StockPaint paint1 = new StockPaint(1.0,yellow);
        StockPaint paint2 = new StockPaint(1.5,blue);
        MixedPaint mix = new MixedPaint();

        mix.mixIn(paint1);
        mix.mixIn(paint2);
        // Class invariant test make assertions about the state of an object at the end of any operation.
        // Invariant can be declared for entire Aggregates, rigorously defining integrity rules.
        assertEquals(2.5,mix.getVolume(),0.01);
    }
}
