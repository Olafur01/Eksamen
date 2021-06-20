import java.util.Random;
import java.util.ArrayList;

class Kryss {
    ArrayList<Sti> stierSomKrysser;

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

}
