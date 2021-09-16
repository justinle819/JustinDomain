package Entity;

import ValueObject.PigmentColor;
import java.util.ArrayList;
import java.util.List;

// Class invariant total volume is unchanged by mixing
public class MixedPaint  extends Paint{
    private List<StockPaint> stockConstituent;

    public MixedPaint() {
        super(0.0, new PigmentColor(0,0,0));
        stockConstituent = new ArrayList<>();
    }

    public void mixIn(StockPaint other) {
        stockConstituent.add(other);
    }

    public double getVolume() {
        double volume = 0.0;
        for(StockPaint stockPaint: stockConstituent) {
            volume += stockPaint.getVolume();
        }
        return volume;
    }

    public PigmentColor getColor() {
        PigmentColor pigmentColor = super.getColor();
        for(StockPaint stockPaint: stockConstituent) {
            pigmentColor = pigmentColor.mixedWith(stockPaint.getColor(), stockPaint.getVolume() / getVolume());
        }
        return pigmentColor;
    }
}
