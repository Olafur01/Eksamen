import java.util.Random;

public class TestTraadSimulator {
    static int ANTALLTURGAAERE = 10;

    public static void main(String[] args) {
        Skog skogen = new Skog(10, 30);
        int hastighet;
        Random rand = new Random();
        System.out.println("begynner NAA");

        for (int i = 0; i < ANTALLTURGAAERE; i++){
            hastighet = Trekk.trekk(20, 220);
            new Thread(new Turgaaer(hastighet, skogen.hentTilfeldigKryss(), i)).start();
        }
        System.out.println("Na har alle traadene startet");
    }
}
