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
public class soldierCollection {

    private final ArrayList<Soldier> soldiers = new ArrayList<>();

    public void addSoldier(Soldier soldier) {
        if (!soldiers.contains(soldier)) {
            soldiers.add(soldier);
        }
    }

    public void removeSoldier(Soldier soldier) {
        if (soldiers.contains(soldier)) {
            soldiers.remove(soldier);
        }
    }

    public void displaySoldiers() {
        if (soldiers.isEmpty()) {
            System.out.println("Sem exercito.");
        } else {
            System.out.println(soldiers.size() + " soldados:");
            for (Soldier soldier : soldiers) {
                int[] position = soldier.soldierPosition();
                System.out.println(soldier.getSoldierClass() + " na posicao (" + position[0] + ',' + position[1] + ')');
            }
        }
    }
}
