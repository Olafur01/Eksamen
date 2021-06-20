class Overlege extends Lege{
    final String spesialisering;

    Overlege(String identifikasjonsNr, String navn, int legeNummer, String spesialisering) {
        super(identifikasjonsNr, navn, legeNummer);
        this.spesialisering = spesialisering;
    }
    
}
