public class Turgaaer extends Aktivitet {
    int hastighet;
    Kryss sted; 
    int tid = 0;


    Turgaaer(int hastighet, Kryss sted) {
        this.hastighet = hastighet;
        this.sted = sted;
    }

    @Override
    int handling() {
        // Beregner tiden det tar for aa gaa fra det krysset hvor en starter
        // Hver gang handling kalles av simuler metoden, saa vil turgaaeren vaere med et nytt kryss 
        // Beregner foerst den nye veien en skal ta fra krysset, som er tilfeldig valg
        Sti nySti = sted.finnNyVeiVidere();
        // Kalkulerer saa tiden det vil ta for aa gaa denne turen 
        int tiden = nySti.beregnGaaTid(hastighet);
        // Setter saa opp det nye krysset som enden av denne stien, som skal vaere i et nytt kryss
        sted = nySti.finnAndreEnde(sted);
        // Sa kalkuleres denne tiden til turgaaren her. 
        tid += tiden;   
        return tiden;
    }
    
}
