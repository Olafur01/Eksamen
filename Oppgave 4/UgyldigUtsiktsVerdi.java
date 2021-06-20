class UgyldigUtsiktsVerdi extends RuntimeException{
    UgyldigUtsiktsVerdi(int verdi){
        super("Ugyldig verid: " + verdi);
    }
}
