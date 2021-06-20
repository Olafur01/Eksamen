

// SVAR TIL OPPGAVE 2F
/*
For aa gjoere denne klassen mer robust og vanskeligere for at en uhelighvis oppdaterer tiden uten vilje eller med vilje
saa kan en sette opp tids variabelene som en private variable. Dette betyr at ingenting utenfor denne klassen kan
modifisere denne, og den eneste maaten aa endre den paa er ved aa implementere en setter metode og saa en getter 
for aa kunne hente denne variabelen ut fra denne klassen. Se endringene laget under med // Endring og metodene
Ettersom spoersmalet bare sier at en skal modifisere denne klassen, saa gjor jeg ikke noen endringer i de andre klassene
som simulator klassen med hvordan en skal oppdatere disse metodene for aa fungere med en private variable i denne 
klassen  
*/
abstract class Aktivitet2 implements Comparable<Aktivitet> {
    Aktivitet neste;
    Aktivitet forrige; 
    private int tid; // Endring

    // Oppgave 2f
    public void settTid(int tid){
        this.tid = tid;
    }
    //Oppgave 2f
    public int hentTid(){
        return this.tid;
    }

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
