public class TestSimulator {
    static int ANTALLTURGAAERE = 10;
    public static void main(String[] args) {
        Skog skogen = new Skog(10, 30);
        Simulator simulatoren;

        Aktivitet [] alleAktivter = new Aktivitet[ANTALLTURGAAERE];
        int hastighet;
    


        for (int i = 0; i < ANTALLTURGAAERE; i++){
            hastighet = Trekk.trekk(20, 200);
            alleAktivter[i] = new Turgaaer(hastighet, skogen.hentTilfeldigStart());
        }

        simulatoren = new Simulator(alleAktivter);
        int simuleringstiden = Trekk.trekk(480, 30); 
        simulatoren.simuler(simuleringstiden);
    }
}
