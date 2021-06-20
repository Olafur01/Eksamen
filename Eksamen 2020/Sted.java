public class Sted {
    private String beskrivelse;
    private Skattekiste kiste;
    private Sted utgang;

    public Sted(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    public void settKiste(Skattekiste kiste){
        this.kiste = kiste;
    }

    public Skattekiste hentKiste(){
        return kiste; 
    }

    public void settUtgang(Sted utgang){
        this.utgang = utgang;
    }

    public Sted hentUtgang(){
        return utgang;
    }

    public String toString(){
        return beskrivelse + kiste;
    }


}
