class KvinneligPasient extends Pasient{

    KvinneligPasient(String navn, String fnr, int prio) {
        super(navn, fnr, prio);
    }

    @Override
    boolean erIFaresone() {
        return Sykehus.erIFaresoneKvinne(this);
    }

    @Override
    void kanHaSykdom() {
       Sykehus.kanHaSykdomKvinne(this);
    }
    
}
