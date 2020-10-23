
/**
 * Game of Dice example
 * @author Luke Hindman
 **/

public class GameOfDice {
    public static void main(String[] args) {
        System.out.println("Welcome to Game of Dice!");

        Die die1 = new Die();
        Die die2 = new Die(64);

        die1.roll();
        die2.roll();

        System.out.println(die1.toString());
        System.out.println(die2);

        /* Get the max of the two die */
        Die maxDie;
        maxDie = Die.max(die1, die2);
        System.out.println("Max Die: " + maxDie);

        System.out.println("Player1's roll: " + die1);
        System.out.println("Player2's roll: " + die2);

        if (die1.compareTo(die2) > 0) {
            System.out.println("Player 1 Wins!");
        } else if (die1.compareTo(die2) < 0) {
            System.out.println("Player 2 Wins!");
        } else {
            System.out.println("Tie game..");
        }
    }
}
