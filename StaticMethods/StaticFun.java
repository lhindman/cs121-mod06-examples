public class StaticFun {
    
    public static void main (String[] args) {
        int a = 16;
        int b = 20;
        int c = 10;

        System.out.println("The max of " + a + ", " + b + ", " + c +  " is: " + Utility.maxOfThree(a,b,c));


        System.out.println("The result of " + a + " cubed is: " + Utility.cube(a));

        /* Generate 10 number in the range of 1 to 100 inclusive */
        for (int i = 0; i < 10; i++) {
            System.out.println("Random number " + i + ": " + Utility.randomInRange(1, 100));
        }
    }
}
