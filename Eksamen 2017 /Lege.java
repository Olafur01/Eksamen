public class Lege extends Ansatt {
    final int legeNummer;

    Lege(String identifikasjonsNr, String navn, int legeNummer) {
        super(identifikasjonsNr, navn);
        this.legeNummer = legeNummer;
    }
    
}
