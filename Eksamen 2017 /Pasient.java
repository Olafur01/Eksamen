abstract class Pasient {
    final String fnr;
    final String navn;
    Pasient neste;
    final static int MAXPASPRIO = 10;
    int prioritet; // 0 <= prioritet <= MAXPASPRIO
    int sengNr = -1;

    abstract boolean erIFaresone();
    abstract void kanHaSykdom();

    Pasient (String navn, String fnr, int prio) {
    this.navn= navn;
    this.fnr = fnr;
    prioritet = prio;
    }
}

