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
public class Castle {

    private final String name;
    private final Position location;
    private int value;
    private Kingdom owner = null;

    public Castle(String id, Position pos, int val) {
        name = id;
        location = pos;
        value = val;
    }

    public int getCurrentMoney() {
        return value;
    }

    public String getCurrentOwner() {
        if (owner == null) {
            return "sem dono";
        } else {
            return owner.getName();
        }
    }

    public void incrementMoney() {
        value++;
    }

    public void recruit(int n) {
        value -= n;
    }

    public void changeOwner(Kingdom k) {
        owner = k;
    }

    public int[] getPosition() {
        return location.getPosition();
    }

    public String getName() {
        return name;
    }
}
