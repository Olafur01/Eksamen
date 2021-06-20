class PasientPrio extends PasientAdm {
    Pasient [] foran = new Pasient[Pasient.MAXPASPRIO + 1];
    Pasient [] bak = new Pasient[Pasient.MAXPASPRIO + 1];
    

    @Override
    void settInnPasient(Pasient p) {
        int prio = p.prioritet;
        if (foran[prio] == null){
            foran[prio] = p;
            bak[prio] = p;
        }
        else{
            // Foelger FIFO metoden, der det som ble plassert inn forst blir tatt ut forst
            // Derfor naar det kommer en ny patient, saa vil disse bli lagt lengst bak i listen, 
            // blant sin prioitetsklasse. 
            Pasient temp = foran[prio];
            // Invariant der vi sjekke om temp.neste er tom eller ikke
            while(temp.neste != null){
                temp = temp.neste;
            }
            temp.neste = p;
            bak[prio] = p;
        }
    }

    @Override
    Pasient hentUt(Pasient p) {
        int prio = p.prioritet;
        Pasient temp = foran[prio];
        if (temp == null) {
            return null;
        }
        if (temp == p){
            foran[prio] = temp.neste;
            if(foran[prio] == null){
                bak[prio] = null;
            }    
        }
        return temp;
    }

    @Override
    Pasient hentUt(int i) {
        return hentUt(foran[i]);
    }
    
}
