package paintcalculator;


import java.util.ArrayList;

public class Room implements Paintable {

    private ArrayList<Wall> wallList;
    private static int roomCount;
    private transient int roomNum;
    private static final int SQUARE_FEET_PER_GALLON = 400;
    

    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
        roomCount++;
        roomNum = roomCount;
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Room: ");
        sb.append(roomNum).append("\nArea: ").append(getArea()).append("\n");
        sb.append("Premium paint cost: $").append(getPremiumCost()).append("\n");
        sb.append("Standard Paint cost: $").append(getStandardCost()).append("\n");
        
        return sb.toString();
    }
    @Override
    public double getPremiumCost()
    {
        double cost = getArea() / SQUARE_FEET_PER_GALLON * PREMIUM_PAINT_COST_PER_GALLON;
        
        return cost;
    }
    @Override
    public double getStandardCost()
    {
        double cost = getArea() / SQUARE_FEET_PER_GALLON * STANDARD_PAINT_COST_PER_GALLON;
        
        return cost;
    }
}
