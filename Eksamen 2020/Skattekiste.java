import java.util.ArrayList;
import java.util.Random;

public class Skattekiste {
    private ArrayList<Gjenstand> kiste = new ArrayList<>();
    static private Random rand = new Random();
    static private final int MAXANTALL = 5;

    public Skattekiste(ArrayList<Gjenstand> kiste){
        this.kiste = kiste;
    }

    public ArrayList<Gjenstand> hentKiste(){
        return kiste;
    }

    public Gjenstand hentUt(int valgt){
        return kiste.remove(valgt);
    }

    public Gjenstand hentUtTilfeldig(){
        if (kiste.isEmpty()) return null;
        return(kiste.remove(rand.nextInt(kiste.size())));
    }

    public void leggTil(Gjenstand g){
        kiste.add(g);
    }

    public int kjopTilfeldigPris(Gjenstand g){
        // Kisten "kjoeper" gjenstand av spiller og setter pris
        kiste.add(g);
        // F.eks. tilfedlig pris mellom 0 og 2 ganger verdien
        return (Math.round(g.hentVerdi()* 2 * rand.nextFloat()));
    }

    public int totalVerdi(){
        int sum = 0;
        for(Gjenstand g: kiste){
            sum += g.hentVerdi();
        }
        return sum;
    }

    public String toString(){
        String beskrivelse = "I denne kisten saa ligger det:\n";
        for(Gjenstand g: kiste){
            beskrivelse += g.hentBeskrivelse() + "\n";
        }
        return beskrivelse + "\n";
    }
}
