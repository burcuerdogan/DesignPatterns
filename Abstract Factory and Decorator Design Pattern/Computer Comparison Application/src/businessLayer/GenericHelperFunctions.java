package businessLayer;

import java.util.Random;

public class GenericHelperFunctions {
    public static int randomNumberGenerator(int lowerLimit, int upperLimit){
        Random rand = new Random();
        int n = rand.nextInt(upperLimit-lowerLimit)+1;
        return n;
    }

    public static int randomNumberGenerator(int lowerLimit, int upperLimit, int increaseSize){
        Random rand = new Random();
        int n = rand.nextInt(upperLimit-lowerLimit)+increaseSize;
        return n;
    }
}
