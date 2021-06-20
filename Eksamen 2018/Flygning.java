import java.util.Iterator;

public class Flygning implements Iterable<Sete>{
    Seterad [] seterader;
    String flightNo;
    
    public Flygning(String flightNo, String seteInfo){
        this.flightNo = flightNo;

        String [] rader = seteInfo.split("|");
        seterader = new Seterad[rader.length];
        for (int i = 0; i < rader.length; i++){
            seterader[i] = new Seterad(rader[i]);
        }
    }

    boolean book(Passasjer pass){
        for (int i = 0; i < seterader.length; i++){
            if (seterader[i].bookPassasjer(pass)){
                return true;
            }
        }
        return false;
    }

    boolean book(Passasjer pas, boolean foretrekkerVindu, boolean foretrekkerMidtgang){
        for (int i = 0; i < seterader.length; i++){
            if(seterader[i].book(pas, foretrekkerVindu, foretrekkerMidtgang)) return true;
        }
        return false;
    }

    boolean book(Passasjer pas1, Passasjer pas2){
        for (int i = 0; i < seterader.length; i++){
            if(seterader[i].book(pas1, pas2)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Sete> iterator() {
        return new seteIterator(this);
    }

    class seteIterator implements Iterator<Sete>{
        Flygning flygning;
        int radIx = 0;
        int seteIx = 0;

        seteIterator(Flygning flygning){
            this.flygning = flygning;
        }


        @Override
        public boolean hasNext() {
            return radIx < flygning.seterader.length;
        }

        @Override
        public Sete next() {
            Sete s = flygning.seterader[radIx].seter[seteIx];
            seteIx++;
            if (seteIx >= flygning.seterader[radIx].seter.length){
                radIx++; seteIx = 0;
            }
            return s;
        }
    }
}
