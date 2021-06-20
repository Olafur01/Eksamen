public class Gjenstand {
    private String beskrivelse;
    private int verdi;

    public Gjenstand(String beskrivelse, int verdi){
        this.verdi = verdi;
        this.beskrivelse = beskrivelse;
    }

    public int hentVerdi(){
        return verdi;
    }

    public String hentBeskrivelse(){
        return beskrivelse;
    }

    public String toString(){
        return "Gjenstand: " + beskrivelse + " med verdi: " + verdi;
    }
}
