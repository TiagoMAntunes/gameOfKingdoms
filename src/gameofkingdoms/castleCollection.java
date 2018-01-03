/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofkingdoms;

import java.util.ArrayList;

/**
 *
 * @author tiagoantunes
 */
public class castleCollection {

    private final ArrayList<Castle> castles = new ArrayList<>();
    
    public void addCastle(Castle castle) {
        if (!castles.contains(castle)) {
            castles.add(castle);
        }
    }
    
    public void removeCastle(Castle castle) {
        if (castles.contains(castle)) {
            castles.remove(castle);
        }
    }
    
    public void displayCastles() {
        for (Castle castle : castles) {
            int[] position;
            position = castle.getPosition();
            System.out.println(castle.getName() + " com riqueza " + castle.getCurrentMoney()+" na posicao (" + position[0] + ',' + position[1] + ')');
        }
    }
    
    public Castle getCastle(String name) {
        for (Castle castle : castles) {
            if (castle.getName().toLowerCase().equals(name.toLowerCase())) {
                return castle;
            }
        }
        return null;
    }
    
    public int numberOfCastles() {
        return castles.size();
    }
    
    public ArrayList<Castle> getAllCastles() {
        return castles;
    }
    
}
