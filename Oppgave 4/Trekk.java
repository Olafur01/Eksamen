import java.util.Random;

class Trekk {

    static int trekk(int min, int max){
        int minimum;
        if (min > 0){
            minimum = 0;
        }
        else{
            minimum = min;
        }
        Random rand = new Random();
        return rand.nextInt(max - minimum) + minimum;
    }
}
