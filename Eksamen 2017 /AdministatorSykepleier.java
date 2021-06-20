public class AdministatorSykepleier extends Sykepleier implements ErAdministrator {
    String ansvarsKode;

    AdministatorSykepleier(String identifikasjonsNr, String navn, String ansvarsKode) {
        super(identifikasjonsNr, navn);
        this.ansvarsKode = ansvarsKode;
    }

    @Override
    public String finnAnsvar() {
        return ansvarsKode;
    }
    
}
