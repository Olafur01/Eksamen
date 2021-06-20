class Simulator {
    int globaltid = 0;
    PrioKo koenAvAktiviteter = new PrioKo();

    // Oppretter kontuktoeren med en array av alle liste og loekker gjennom disse
    // og legger de inn i priokoen 
    Simulator(Aktivitet[] alleAktiviteter){
        for (Aktivitet a: alleAktiviteter){
            koenAvAktiviteter.settInn(a);
        }
    }

    void simuler(int t){
        while(globaltid < t){
            Aktivitet nesteAktivitet = koenAvAktiviteter.hentUt();
            globaltid = nesteAktivitet.tid;
            // Tiden til handlingen blir oekt inne i objektet selv, er i alle fall slik jeg tolker det 
            nesteAktivitet.handling();
            koenAvAktiviteter.settInn(nesteAktivitet);
        }
    }
   
}
