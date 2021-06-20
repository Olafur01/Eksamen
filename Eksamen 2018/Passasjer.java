public class Passasjer {
    String navn;
    double hoeyde;

    Passasjer(String navn, double hoeyde){
        this.navn = navn;
        this.hoeyde = hoeyde;
    }

    public boolean harLangeBen(){
        return hoeyde >= 190;
    }

    void skrivUt(){
        System.out.println("Navn:" + navn + "Har lange bein: " + (harLangeBen() ? "Ja" : "Nei"));
    }
}
