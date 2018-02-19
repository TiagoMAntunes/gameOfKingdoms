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
public class kingdomCollection {
    private ArrayList<Kingdom> kingdomList = new ArrayList<>();
    private int index = 0;

    public Kingdom getNextKingdom() {
        index++;
        return this.getCurrentKingdom();
    }
    
    public Kingdom getCurrentKingdom() {
        Kingdom current = kingdomList.get(index % kingdomList.size());
        return current;
    }
    
    public void addKingdom(Kingdom k) {
        kingdomList.add(k);
    }
    
    public boolean checkIfKingdomExists(String kingdomName) {
        for (Kingdom kingdom : kingdomList) {
            if (kingdom.getName().equals(kingdomName)) {
                return true;
            }
        }
        return false;
    }
    
    public int nKingdoms() {
        return this.kingdomList.size();
    }
    
    public void displayKingdoms() {
        String r = "";
        int i = 0;
        while (!kingdomList.get(i).equals(kingdomList.get(kingdomList.size() - 1))) { //while current kingdom differs from last one
            r = r + kingdomList.get(i).getName() + "; ";
            i++;
        }
        r = r + kingdomList.get(kingdomList.size() - 1).getName();
        System.out.println(r);
        
    }
}
