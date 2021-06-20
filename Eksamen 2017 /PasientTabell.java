public class PasientTabell extends PasientAdm{
    Pasient [] tabell;
    int letPos = 0;

    PasientTabell(int lengde){
        tabell = new Pasient[lengde];
    }

    @Override
    void settInnPasient(Pasient p) {
        int startPos = letPos;
        while(true){
            if(tabell[letPos] == null){
                tabell[letPos] = p;
                p.sengNr = startPos;
                return;
            }
            letPos++;
            // Har gaat gjennom lengden av tabellen, saa maa starte paa nytt
            if (letPos >= tabell.length) letPos = 0;
            // Det er ingen ledige plasser igjen ettersom vi har gaat gjennom alle sengene
            if (letPos == startPos) return;
        }
       
    }

    @Override
    Pasient hentUt(Pasient p) {
        if(tabell[p.sengNr] != null){
            Pasient temp = tabell[p.sengNr];
            tabell[p.sengNr] = null;
            temp.sengNr = -1;
            return temp;
        }
        return null;
    }

    @Override
    Pasient hentUt(int i) {
        for (int j = 0; j <= tabell.length; j++){
            if(tabell[j].prioritet == i && tabell[j] != null){
                Pasient temp = tabell[j];
                tabell[j] = null;
                temp.sengNr = -1;
                return temp;
            }
        }    
    return null;
    }
    
}
