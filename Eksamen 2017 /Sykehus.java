import java.util.concurrent.CountDownLatch;

public class Sykehus {
    Avdeling akutten, sengeplass;

    void skriverInnPasient(Pasient p, Avdeling a){
        a.settInn(p);
        
    }

    void overfoer(Pasient p, Avdeling a, Avdeling b){
        if(a.hentUt(p) != null) b.settInn(p);
        System.out.println("Overfoerer naa " + p.navn + " fra Akutten til sengeplass");
    }

    Pasient hentUt(Pasient p, Avdeling a){
        return a.hentUt(p);
    }

    public static boolean kanHaSykdomMann(Pasient p){
        return true;
    }
    
    public static boolean erIFaresoneKvinne(Pasient p){
        return true;
    }

    public static boolean kanHaSykdomKvinne(Pasient p){
        return true;
    }

    public static boolean erIFaresoneMann(Pasient p){
        return true;
    }

    public static void utforAnalyse(PasientPrio beholder, int antAnalyser){
        AnalyseBuffer monitor = new AnalyseBuffer();
        CountDownLatch cdlPasient = new CountDownLatch(Pasient.MAXPASPRIO +1); // F
        CountDownLatch analyseCdl = new CountDownLatch(antAnalyser); // F
        for (int i = 0; i <= Pasient.MAXPASPRIO; i++){
            new Thread(new Sil(beholder, monitor, i, cdlPasient)).start(); //F
        }
        for (int i = 0; i < antAnalyser; i++){
            new Thread(new AnalyseTraad(monitor, analyseCdl)).start(); //F
        }
        try{
            cdlPasient.await(); // F
            monitor.kommerFlere = false; // F
            analyseCdl.await();// F
        }
        catch(InterruptedException e){}
    }

    public static void main(String [] args){
        Sykehus sykehuset = new Sykehus();
        Pasient jens = new ManneligPasient("Jens Hooper", "jens", 10);
        Pasient jacob = new ManneligPasient("Jacob kruger", "Jacob", 2);
        sykehuset.akutten = new Akutten();
        sykehuset.sengeplass = new Sengepost(10);
        sykehuset.skriverInnPasient(jens, sykehuset.akutten);
        sykehuset.skriverInnPasient(jacob, sykehuset.akutten);
        sykehuset.overfoer(jens, sykehuset.akutten, sykehuset.sengeplass);
    }

}
