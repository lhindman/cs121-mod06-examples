import java.util.Random;

/**
 * The Die class represents a single Die object for use
 *    in game development.
 * @author Luke Hindman
 */
public class Die implements Rollable, Comparable<Die>{
    /* 1. Instance Variables */
    private int faceValue;
    private int numSides;

    /* 2. Constructor(s) */
    /**
     * Default constructor for Die object. Sets faceValue to 1 and 
     *    initizes Die with six sides.
     */
    public Die() {
        faceValue = 1;
        numSides = 6;
    }

    /**
     * Initial value constructor for Die object.  Sets faceValue to 1 and
     *     initizes a new Die object with the specified number of sides.
     * 
     * @param numSides The number of sides for the new Die 
     */
    public Die(int numSides) {
        faceValue = 1;
        this.numSides = numSides;
    }
    /* 3. Other methods */

    public int roll() {
        Random gen = new Random();
        this.faceValue = gen.nextInt(this.numSides) + 1;
        return this.faceValue;
    }

    /**
     * Get the current faceValue
     * @return The current faceValue of the Die
     */
    public int getFaceValue() {
        return this.faceValue;
    }

    /**
     * Update the faceValue of the Die object to the 
     *    specified value.
     * @param faceValue New value to set on Die
     */
    public void setFaceValue(int faceValue) {
        if (faceValue > 0 && faceValue <= this.numSides){
            this.faceValue = faceValue;
        }
    }

    public String toString() {
        String output  = "";

        output += "The value of my beautiful " + this.numSides + " sided die is: " + this.faceValue;

        return output;
    }

    /* Static methods */
    /**
     * Compare the faceValue of two Die objects and return a reference
     *    to the Die with the greater faceValue. If both d1 and d2 have 
     *    same faceValue, return d1.
     * @param d1 Die object to be compared
     * @param d2 Die object to be compared
     * @return Reference to whichever has larger faceValue, d1 or d2
     */
    public static Die max(Die d1, Die d2) {
        if (d1.getFaceValue() >= d2.getFaceValue()) {
            return d1;
        } else {
            return d2;
        }
    }

    /* Comparable Interface Methods*/
    @Override
    public int compareTo(Die arg0) {
        // if (this.getFaceValue() > arg0.getFaceValue()) {
        //     return 1;
        // } else if (this.getFaceValue() < arg0.getFaceValue()) {
        //     return -1;
        // } else {
        //     return 0;
        // }
        return this.getFaceValue() - arg0.getFaceValue();
    }

    
}
