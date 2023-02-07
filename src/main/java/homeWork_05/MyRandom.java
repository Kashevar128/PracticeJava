package homeWork_05;

public class MyRandom {

    public static int getIntRand(int min, int max) {
        int i = (int) (Math.random() * (max - min + 1)) + min;
        return i;
    }
}
