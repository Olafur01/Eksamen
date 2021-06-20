class GodUtsiktNatursti extends Naturstier implements MedGodUtsikt {
    int utsiktsVerdi;

    GodUtsiktNatursti(int lengde, Kryss startpunkt, Kryss endepunkt, int utsiktsverdi){
        super(lengde, endepunkt, endepunkt);

        if(utsiktsVerdi > 1 || utsiktsverdi > 6){
            throw new UgyldigUtsiktsVerdi(utsiktsverdi);
        }
    }
    
    @Override
    public int hentUtsiktsVerdi() {
        return utsiktsVerdi;
    }
    
}
