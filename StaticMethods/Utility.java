import java.util.Random;

public class Utility {
    
    /* static methods */
    public static int maxOfThree(int x, int y, int z) {
        int max = Math.max(x,y);
        max = Math.max(max,z);
        return max;
    }

    public static int cube(int x) {
        return x * x * x;
    }

    public static int randomInRange(int low, int high) {
        Random rand = new Random();
        int value = rand.nextInt(high - low + 1) + low;
        return value;
    }

}
