public class CupOfDiceDriver {
    public static void main (String[] args) {

        CupOfDice myCup = new CupOfDice(10, 64);

        myCup.shake();

        System.out.println(myCup);
    }
}
