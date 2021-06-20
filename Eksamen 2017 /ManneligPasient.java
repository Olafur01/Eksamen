class ManneligPasient extends Pasient {

    ManneligPasient(String navn, String fnr, int prio) {
        super(navn, fnr, prio);
    }

    @Override
    boolean erIFaresone() {
        return Sykehus.erIFaresoneMann(this);
    }

    @Override
    void kanHaSykdom() {
        Sykehus.kanHaSykdomKvinne(this);
    }
    
}
