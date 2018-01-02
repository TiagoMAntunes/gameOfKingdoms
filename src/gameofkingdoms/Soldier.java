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
public class Soldier {

    private final String type;
    private final Position position;

    public Soldier(String soldierClass, int x, int y) {
        type = soldierClass;
        position = new Position(x, y);
    }

    public boolean winsAgainst(Soldier otherOponnent) {
        //returns the result of attacking an enemy unit

        switch (this.type.toLowerCase()) {
            case "cavaleiro":
                return !otherOponnent.type.equals("lanceiro");
            case "lanceiro":
                return !otherOponnent.type.equals("espadachim");
            case "espadachim":
                return !otherOponnent.type.equals("cavaleiro");
            default:
                return false; //in case something goes wrong, soldier dies
        }
    }

    public int[] soldierPosition() {
        return this.position.getPosition();
    }
    
    public Position getNextPosition(String direction) {
        //move unit accordingly to direction
        int[] nextPosition = this.position.getPosition();
        switch (direction.toLowerCase()) {
            case "norte":
                nextPosition[1] += 1;
                break;
            case "sul":
                nextPosition[1] -= 1;
                break;
            case "oeste":
                nextPosition[0] += 1;
                break;
            case "este":
                nextPosition[0] -= 1;
                break;
        }
        Position newPosition = new Position(nextPosition[0], nextPosition[1]);
        return newPosition;
    }
    
    public void updatePosition(Position newPosition) {
        int[] coords = newPosition.getPosition();
        this.position.updatePosition(coords[0], coords[1]);
    }
    
    public String getSoldierClass() {
        return this.type;
    }
}
