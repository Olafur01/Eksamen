// Oppretter Priokoen med Aktivitet som data, ettersom turgaar bare er en ting,
// det kan vaere flere typer aktiviteter
class PrioKo {
    Node hode;
    int teller = 0;

    public int antall(){
        return teller;
    }

    private class Node {
        Node neste = null;
        Node forrige = null;
        Aktivitet data;

        Node(Aktivitet data){
            this.data = data;
        }
    }

    void settInn(Aktivitet a){
        Node nyNode = new Node(a);
        teller++;
        if (hode == null){
            hode = nyNode;
        }
        // Bruker compareTo for aa sjekke om tiden er kortere en den andre
        // Kunne ogsa bare brukt tid. Oppretter det slik at hvis to aktiviteter 
        // har lik tid, saa vil den nyeste komme inn forst. Benytter en LIFO metode, 
        // ettersom det ikke staar noe i oppgaveteksten om dette
        Node temp = hode;
        // Gaar til slutten av listen 
        while (temp.neste != null){
            temp = temp.neste;
        }       
        temp = temp.forrige;
        // Oppretter en invariant der hvis temp sin aktivitet tar korrere tid, 
        // saa gaar vi videre inn ned i lenkelisten 
        while (temp.forrige.data.compareTo(nyNode.data) <= 0){
            temp = temp.forrige;
        }
        // Har naa funnet en ny plass hvor tiden er kortere 
        // Setter forst nyNode som temp sin neste
        nyNode.neste = temp.forrige;
        nyNode.data.setNeste(temp.forrige.data);
        // Saa er nyNode sin forrige temp
        nyNode.forrige = temp.forrige.forrige;
        nyNode.data.settForrige(temp.forrige.forrige.data);
        temp.forrige = nyNode;
        temp.data.settForrige(nyNode.data);
    }
       
       

    public Aktivitet hentUt(){
        if (hode == null){
            return null;
        }
        else{
            Node temp = hode;
            hode = temp.neste;
            // Naa som vi tar ut den foerste, saa ma den som er bak denne slette sin referanse til den 
            hode.forrige = null;
            teller--;
            return temp.data;
        }
    }

}
