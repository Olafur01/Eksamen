import java.util.Random;
import java.util.ArrayList;

class Kryss {
    ArrayList<Sti> stierSomKrysser;
    Kryss naboKryss; 
    ArrayList<Kryss> viHarVeartInnom;

    Kryss(ArrayList<Sti> stierSomKrysser){
        this.stierSomKrysser = stierSomKrysser;
    }

    Sti finnNyVeiVidere(){
        // Velger en random sti fra de som er i krysset
        Random rand = new Random();
        // Tar vekk en ettersom hvis vi tar stoerresle
        int length = stierSomKrysser.size() - 1;
        return stierSomKrysser.get(rand.nextInt(length));
    }

    boolean erIsolert(){
        // Hvis det er ingen stier i arrayListen sa er den isolert 
        if(stierSomKrysser.size() == 0) return true;
        return false;
    }

    void addSti(Sti nySti){
        stierSomKrysser.add(nySti);
    }

    // Hoved rekusjonsfunksjonen her, som kaller paa en hjelperfunksjon 
    boolean finnesVeiTil(Kryss kryss2){
        return finnesVeiTil(kryss2, 0);
    }
    
    // Metode som sjekker om de to kryssene er nabokryss, som betyr at de allerede har to stier 
    // som binder dem sammen 
    boolean erNaboKryss(Kryss kryss2){
        Sti nySti = null;
        // Loekker gjennom alle stiene som er i krysset, og sjekker alle endepunkter for hver sti 
        for (int i = 0; i < stierSomKrysser.size(); i++){
            nySti = stierSomKrysser.get(i);
            // Sjekker om det andre enepunktet er kryss2, hvis det er det saa er disse to kryssene naboer
            if (nySti.finnAndreEnde(this).equals(kryss2)){
                return true;
            }
        }
        return false;
    }

    boolean finnesVeiTil(Kryss kryss2, int teller){
        // Base case
        // Her hvis telleren har blitt like stor som antallstier i dette krysset, saa finnes det ikke
        // lenger noen utveier 
        if (teller >= this.stierSomKrysser.size()){
            return false;
        }

        // Rekursjonssteget 
        else{
            // Sjekker om de to kryssene er nabokryss, hvis det er det, sa finnes det en vei mellom de 
            // og det returneres true 
            if(this.erNaboKryss(kryss2)) return true;
            // Henter en sti som er inne i beholderen av stier som krysset har 
            Sti nySti = stierSomKrysser.get(teller);
            // Etter aa sjekke motkrysset til det krysse vi allerede er inne i, saa vil vil rekursivt se 
            // om det finnes en vei mellom denne og det andre 
            Kryss nyttKryss = nySti.finnAndreEnde(this);

            // Her vil vi sjekke om en av de andre stiene i dette krysset allerede krysset med den andre eller ikke 
            // og sjekker om det finnes noe andre tryss som kan benytter  
            return nyttKryss.finnesVeiTil(kryss2, teller) || finnesVeiTil(kryss2, teller++);
        }

    }

}
