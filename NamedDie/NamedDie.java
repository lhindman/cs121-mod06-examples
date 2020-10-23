public class NamedDie extends Die {
    /* Instance Variables */
    private String name;

    /* Constructor */
    public NamedDie(String name, int numSides) {
        super(numSides);
        this.name = name;
    }

    /* Other Methods */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        String output = "";
        
        output += this.name + " shows a " + this.getFaceValue();

        return output;
    }


}
