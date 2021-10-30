import java.util.ArrayList;
import java.util.Random;

public class Bag {

    Random rand = new Random();
    ArrayList<Integer> pebbles = new ArrayList<Integer>();
    Bag bagPair;
    String bagColour;

    Bag(String bagColour) {this.bagColour = bagColour;}

    //get and set methods for the list of pebbles in the bags
    public ArrayList<Integer> getPebbles() {return this.pebbles;}
    public void setPebbles(ArrayList<Integer> pebbles) {this.pebbles = pebbles;}

    //get and set methods for the bag pairs of each bag
    public Bag getBagPair() {return bagPair;}
    public void setBagPair(Bag bagPair) {this.bagPair = bagPair;}//not sure if this will work

    //get and set methods for the bag colours of each bag
    public String getBagColour() {return bagColour;}
    public void setBagColour(String bagColour) {this.bagColour = bagColour;}

    //draw pebble from a chosen bag method
    public int drawPebble() {
        if (this.getPebbles().size() == 0) {
            //return -1 if empty list
            return -1;
        } else {
            //else generate a random index for the list used to randomly select a pebble from the list
            int index = rand.nextInt(this.getPebbles().size());
            int pebbleWeight = this.getPebbles().get(index);
            //remove the pebble from the list
            this.getPebbles().remove(index);
            //return the weight of the selected pebble
            return pebbleWeight;
        }
    }

    //method for discarding pebble into selected bag from a selected player
    public void discardPebble(Player thisPlayer, int replacementPebble) {
        int discarded = thisPlayer.discardPebble(replacementPebble);
        this.getPebbles().add(discarded);
    }

    //method to empty a white bag into an empty black bag
    public void refillBag() {
        this.setPebbles(this.getBagPair().getPebbles());
        this.getBagPair().getPebbles().clear();
    }




}
