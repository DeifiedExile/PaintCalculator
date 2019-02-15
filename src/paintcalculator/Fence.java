
package paintcalculator;



public class Fence implements Paintable {

     @Override
    public double getPremiumCost()
    {
        return 25;
    }
    @Override
    public double getStandardCost()
    {        
        return 10;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Fence: \n");
        sb.append("Premium paint cost: $").append(getPremiumCost()).append("\n");
        sb.append("Standard Paint cost: $").append(getStandardCost()).append("\n");
        
        return sb.toString();
    }
    
}
