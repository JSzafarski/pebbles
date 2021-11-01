import java.util.ArrayList;
import java.util.Random;

public class Player{
    int  playerID;
    int[] pebbles = new int[10];
    Random rand = new Random();
    int totalWeight;

    public int getTotalWeight() {return totalWeight;}

    public void setTotalWeight(int totalWeight) {this.totalWeight = totalWeight;}

    public int getPlayerID() {
        return playerID;
    }

    public int[] getPebbles() {
        return pebbles;
    }

    public void setPebbles(int[] pebbles) {
        this.pebbles = pebbles;
    }//

    public void updateWeight(int newPebble, int oldPebble){//true = add,false = remove
        this.setTotalWeight(this.getTotalWeight() - oldPebble + newPebble);
    }

    public Player(int playerID) {
        this.playerID = playerID;
    }

    //takes a new pebble randomly adds it to the players hand in place of another pebble and returns the old pebble

    public int discardPebble(int replacementPebble) {
        int index = rand.nextInt(this.getPebbles().length-1);
        int discardPebble = this.getPebbles()[index];
        this.getPebbles()[index] = replacementPebble;
        this.updateWeight(replacementPebble, discardPebble);
        return discardPebble;
    }

    //calculates the total weight of a player's hand
    public void calculateTotalWeight(){
        int totalWeight = 0;
        for (int i : this.getPebbles()) {
            totalWeight = totalWeight + i;
        }
        this.setTotalWeight(totalWeight);
    }
}
