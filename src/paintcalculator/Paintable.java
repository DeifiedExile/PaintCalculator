
package paintcalculator;

import java.io.Serializable;

public interface Paintable extends Serializable {
    double PREMIUM_PAINT_COST_PER_GALLON = 65.99;
    double STANDARD_PAINT_COST_PER_GALLON = 25.99;
    
    
    public double getPremiumCost();
    public double getStandardCost();
}
