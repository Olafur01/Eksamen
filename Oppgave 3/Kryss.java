import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

class Kryss {
    ArrayList<Sti> stierSomKrysser;
    //Definerer at det er fire ledige sitteplasser ved alle kryss 
    static final int ANTALL_SETER = 4;
    int antallLedigePlasser;
    // Oppretter det som vil tilsvare en benk, som blir en beholder som tar maks 4 turgaaere 
    Turgaaer[] benk = new Turgaaer[ANTALL_SETER];
    Lock laas = new ReentrantLock();
    Condition ikkePlass = laas.newCondition();

    Kryss(ArrayList<Sti> stierSomKrysser){
        this.stierSomKrysser = stierSomKrysser;
        // Naar krysset opprettes saa er det 4 ledige sitteplasser hver gang. 
        antallLedigePlasser = ANTALL_SETER;
    }

    Sti finnNyVeiVidere(){
        // Velger en random sti fra de som er i krysset
        Random rand = new Random();
        // Tar vekk en ettersom hvis vi tar stoerresle
        int length = stierSomKrysser.size() - 1;
        return stierSomKrysser.get(rand.nextInt(length));
    }

    void turGaaerKommer(Turgaaer turgaaer){
        laas.lock();
        try{
            while(antallLedigePlasser == 0){
                // Ikke noe plass, maa derfor vente.
                ikkePlass.await();
            }
            // Finner den ledige plassen paa benken 
            for (int i = 0; i < ANTALL_SETER; i++){
                if(benk[i] == null){
                    benk[i] = turgaaer;
                }
            }
            antallLedigePlasser--;
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        finally{
            laas.unlock();
        }
    }

    // Maa returnere den riktige turgaaren tilbake, derfor tar vi inn dette som en variable for aa finne den riktige
    // personen aa returnere 
    Turgaaer gaarFraBenk(Turgaaer turgaaer){
        Turgaaer temp = null;
        laas.lock();
        try{
            for (int i = 0; i < ANTALL_SETER; i++){
                if(benk[i].equals(turgaaer)){
                    // VI setter denne variablen som tas ut som temp, og gjor sete ledig ved aa sette 
                    // det lik null
                    temp = benk[i];
                    benk[i] = null;
                    // Oeker antall ledige plasser naar disse er ferdig 
                    antallLedigePlasser++;
                }
            }
            // Signaliserer til de troette turgaarene som venter at de naa kan sette seg ned aa slappe av 
            ikkePlass.signalAll();
        }
        finally{
            laas.unlock();
        }
        return temp;
    }

    int antallLedige(){
        return antallLedigePlasser;
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
