import java.util.ArrayList;

public class CupOfDice {
    /* Instance Variables */
    private ArrayList<Die> cup;

    /* Constructor */
    public CupOfDice() {
        this.cup = new ArrayList<Die>();

        for (int i = 0; i < 5; i++) {
            Die d = new Die();
            this.cup.add(d);
        }
    }

    public CupOfDice(int numDice, int numSides) {
        this.cup = new ArrayList<Die>();

        for (int i = 0; i < numDice; i++) {
            Die d = new Die(numSides);
            this.cup.add(d);
        }
    }

    public void shake() {
        for(Die d: this.cup) {
            d.roll();
        }
    }

    public int score() {
        int score = 0;

        for (Die d: this.cup) {
            score += d.getFaceValue();
        }
        
        return score;
    }

    public String toString() {
        String output = "Cup Score: " + this.score() + "\n" + "Cup contents of the CupOfDice is: \n";

        for (Die d: this.cup) {
            output += "\t- " + d.toString() + "\n";
        }

        return output;
    }



    /* Other Methods */
}
