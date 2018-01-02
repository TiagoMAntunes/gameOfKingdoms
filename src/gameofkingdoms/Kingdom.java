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
public class Kingdom {
    private final String name;
    private final castleCollection castles = new castleCollection();
    private final soldierCollection army = new soldierCollection();
    
    public Kingdom(String n) {
        name = n;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void displayAllSoldiers() {
        army.displaySoldiers();
    }
    
    public void displayAllCastles() {
        castles.displayCastles();
    }
    
    public void addCastle(Castle castle) {
        castles.addCastle(castle);
        castle.changeOwner(this);
    }
    
    public void addSoldier(Soldier soldier) {
        army.addSoldier(soldier);
    }
    
    
}
