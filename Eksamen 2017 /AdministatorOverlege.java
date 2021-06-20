class AdministatorOverlege extends Overlege implements ErAdministrator{
    String ansvarsKode;

    AdministatorOverlege(String identifikasjonsNr, String navn, int legeNummer, String spesialisering, String ansvarsKode) {
        super(identifikasjonsNr, navn, legeNummer, spesialisering);
        this.ansvarsKode = ansvarsKode;
        
    }

    @Override
    public String finnAnsvar() {
        return ansvarsKode;
    }

}
    

