import java.util.Iterator;

public class Main implements Iterable<Flygning> { 

    // Skriver ingenting for denne klasse per instruks 
    static void mistenkelig(Passasjer pas){

    }

    // 


    public static void main(String[] args){
        Flygning fly = new Flygning("Mini-1", "2:AC*D+F+|3:C*D|4:AC*DF");
        // Initierer flere fly her;

        String mistenkelig = args[0];
        MistenkeligePersoner mistenkeligePersoner = new MistenkeligePersoner();

        Iterator<Flygning> flyIt = alleFlygninger();
        while (flyIt.hasNext()){
            Flygning flyTemp = flyIt.next();
            new Thread(new Forstelinjevokter(mistenkelig, mistenkeligePersoner, flyTemp)).start();
        }

        for(int i = 0; i < 100; i++){
            new Thread(new Andrelinjevokter(mistenkeligePersoner)).start();
        }
    }

    @Override
    public Iterator<Flygning> iterator() {
        return new FlyIterator();
    }

}
