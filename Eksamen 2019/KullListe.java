import java.util.Iterator;

public class KullListe extends Kull implements Iterable<Hund>{
    Hund foerste = null;

    KullListe(Hund mor, Hund far) {
        super(mor, far);
    }


    @Override
    public void settInn(Hund h) {
        if (foerste == null){
            foerste = h;
            return;
        }
        else if(foerste.minFodselstid.compareTo(h.minFodselstid) > 0){
            h.neste = foerste;
            foerste = h;
            return;
        }
        else{
            Hund temp = foerste;
            // Invariant temp.foedelsaar > h.foedselsaar
            while (temp.neste != null && temp.neste.minFodselstid.compareTo(h.minFodselstid) < 0){
                temp = temp.neste;
            } 
            h.neste = temp.neste;
            temp.neste = h;

        }
        
    }

    @Override
    public Iterator<Hund> iterator() {
        return new HundeIterator(foerste);
    }

    public class HundeIterator implements Iterator<Hund>{
        Hund denne;

        HundeIterator(Hund foerste){
            this.denne = foerste;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public Hund next() {
            Hund temp = denne;
            denne = denne.neste;
            return temp;
        }

    }
    
}
