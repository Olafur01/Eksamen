public class Sete implements MidtgangSete {
    char seteNr;
    int radNr;
    Passasjer person = null;
    boolean hoeyreForMidtgang = false;
    boolean venstreForMidtgang = false;
    boolean erVindusete = false;

    Sete(int radNr, char seteNr){
        this.seteNr = seteNr;
        this.radNr = radNr;
    }

    @Override
    public boolean erVedMidgang() {
        return venstreForMidtgang || hoeyreForMidtgang;
    }

    boolean erVindusete(){
        return erVindusete;
    }

    boolean passerForLangeBein(){
        return false;
    }

    void skrivut(){
        System.out.println("" + radNr + seteNr + "(" + (erVedMidgang() ? "M" : "") + ")" + "(" + (erVindusete() ? "V" : ""));
        if (person != null){
            person.skrivUt();
        }
    }



}
