// Oppretter dette som en abstrakt klasse, ettersom vi implementerer dette for turgaaere 
// og med handlinger 
abstract class Aktivitet implements Comparable<Aktivitet> {
    Aktivitet neste;
    Aktivitet forrige; 
    int tid; 

    void setNeste(Aktivitet neste){
        this.neste = neste;
    }

    Aktivitet hentNeste(Aktivitet neste){
        return neste;
    }

    void settForrige(Aktivitet forrige){
        this.forrige = forrige;
    }

    Aktivitet settForrige(){
        return forrige;
    }

    // blir informert pa slutten av side 4 at denne metoden skal oke den lokale tiden til tidspunktet i fremtiden
    // der aktivitetn ufores av simulator. Da skal aktivitet til slutt gi ut hvilken tid den har brukt 
    abstract int handling();


    @Override 
    public int compareTo(Aktivitet akt){
        return tid - akt.tid;
    }

}
