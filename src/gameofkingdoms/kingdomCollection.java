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
public class kingdomCollection {

    private int index = 0;
    private final Kingdom[] kingdomList;
    private final int maxIndex;

    public kingdomCollection(int nKingdoms) {
        kingdomList = new Kingdom[nKingdoms];
        maxIndex = nKingdoms;
    }

    public Kingdom getNextKingdom() {
        Kingdom next = kingdomList[index%maxIndex];
        index++;
        return next;
    }
    
    public Kingdom getCurrentKingdom() {
        Kingdom current = kingdomList[index%maxIndex];
        return current;
    }
    
    public void addNthKingdom(Kingdom k, int i) {
        kingdomList[i] = k;
    }
}
