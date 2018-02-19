/*
 *  This class specifies a location for each game element
*/
package gameofkingdoms;

/**
 *
 * @author tiagoantunes
 */
public class Position {
    private int x;
    private int y;
    
    public Position(int posX, int posY) {
        x = posX;
        y = posY;
    }
    
    public int[] getPosition() {
        int[] position = new int[2];
        position[0] = x;
        position[1] = y;
        return position;
    }
    
    public void updatePosition(int xValue, int yValue) {
        //updates position relatively
        x += xValue;
        y += yValue;
    }
}
