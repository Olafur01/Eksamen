import java.util.Iterator;

public class KullArray extends Kull {
    Hund [] kull = new Hund[60];

    KullArray(Hund mor, Hund far) {
        super(mor, far);
    
    }

    @Override
    public void settInn(Hund h) {
        int sek = h.minFodselstid.sek;
        if (kull[sek] == null){
            kull[sek] = h;
        }
        else{
            Hund temp = kull[sek];
            // Invariant hvor temp.neste != null
            while (temp.neste != null){
                temp = temp.neste;
            }
            temp.neste = h; 
        }
    }

    public void skrivUt(){
        for (int i = 0; i <kull.length; i++){
            if (kull[i] != null){
                System.out.println(kull[i].navn);
                Hund temp = kull[i];
                while(temp.neste != null){
                    System.out.println(temp.navn);
                    temp = temp.neste;
                }
            }
        }
    }

    @Override
    public Iterator<Hund> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
