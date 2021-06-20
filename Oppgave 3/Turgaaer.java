import java.util.Random;

public class Turgaaer implements Runnable {
    int hastighet;
    Kryss sted; 
    int tid = 0;
    int id;


    Turgaaer(int hastighet, Kryss sted, int id) {
        this.hastighet = hastighet;
        this.sted = sted;
        this.id = id;
    }

    @Override
    public void run() {
        Random rand = new Random();
        System.out.println("Turgaar " + id + " starter naa paa sin tur");
        while(tid < 120){
            Sti nySti = sted.finnNyVeiVidere();

            // Kalkulerer saa tiden det vil ta for aa gaa denne turen 
            int tiden = nySti.beregnGaaTid(hastighet);
            sted = nySti.finnAndreEnde(sted);
           
            sted.turGaaerKommer(this);
            int venteTid = Trekk.trekk(1, 5);
            
            try{
                Thread.sleep(1000*venteTid);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            // Legger til slutt sammen lengden av tid som personen brukte 
            // Staar ingenting i oppgaven, men antar at tur tiden ogsaa skal inkludere tiden som turgaaeren 
            // brukte paa venting 
            tid = tid + tiden + venteTid; 
            System.out.println("Turgaaer " + id + " sitter na ved en benk, og har brukt" + tid + " minutter paa turen sin");
            sted.gaarFraBenk(this);
        }
    }
    
}
