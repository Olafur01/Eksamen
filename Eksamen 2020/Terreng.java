import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Terreng {
    protected ArrayList<Sted> steder = new ArrayList<>();
    final private static int GJENSTANDER_PER_STED = 3;
    protected Random rand = new Random();
    protected Scanner stedFil;
    private ArrayList<Gjenstand> gjenstander; //Alle gjenstander som eksisterer 

    Terreng(String stederFilNavn, String gjenstanderFilNavn){
        lesSteder(stederFilNavn);
        lesGjenstander(gjenstanderFilNavn);
        lagPrimerVei(); // Sikrer at alle stedet blir lenket sammen 
        leggGjenstanderIKiste();
    }


    public Sted hentSted(){ // Lever random inngang til starten av spillet 
        return steder.get(rand.nextInt(steder.size() -1));
    }

    private void lesSteder(String stedFilnavn){
        stedFil = apneFil(stedFilnavn);
        Sted nytt;
        while (stedFil.hasNextLine()){
            nytt = lagSted();
            steder.add(nytt);
        }
        stedFil.close();
    }

    protected Sted lagSted(){
        return new Sted(stedFil.nextLine());
    }

    private void lesGjenstander(String gjenstanderFilnavn){
        Scanner fil = apneFil(gjenstanderFilnavn);
        gjenstander = new ArrayList<>();
        Gjenstand  ny = null;
        while(fil.hasNextLine()){
            ny = new Gjenstand(fil.next(), fil.nextInt());
            gjenstander.add(ny);
        }
        fil.close();
    }

    private Scanner apneFil(String filnavn) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Finner ikke fil " + filnavn);
            System.exit(1);
        }
        return sc;
    }

    private void lagPrimerVei(){
        for (int i = 0; i < steder.size()-1; i++){
            steder.get(i).settUtgang(steder.get(i+1));
        }
        steder.get(steder.size()-1).settUtgang(steder.get(0)); // Oppretter syklisk gjennomgang 
    }

    private void leggGjenstanderIKiste(){
        Random r = new Random();
        ArrayList<Gjenstand> temp;
        for (Sted sted: steder){
            temp = new ArrayList<>();
            for(int i = 0; i < GJENSTANDER_PER_STED; i++){
                Gjenstand ny = gjenstander.get(r.nextInt(gjenstander.size()));
                while (temp.contains(ny)){
                    ny = gjenstander.get(r.nextInt(gjenstander.size()));
                }
                temp.add(ny);
            } 
            sted.settKiste(new Skattekiste(temp));
        }
    }

    public String toString(){
        String s = "\nAlle Steder\n";
        for (Sted her: steder){
            s += her + "\n";
        }
        return s;
    }

    
}
