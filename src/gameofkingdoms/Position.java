/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        x += xValue;
        y += yValue;
    }
}
