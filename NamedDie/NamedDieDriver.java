public class NamedDieDriver {
    public static void main(String[] args) {
        NamedDie die1 = new NamedDie("High Roller", 64);

        die1.roll();

        System.out.println(die1);
    }
}
