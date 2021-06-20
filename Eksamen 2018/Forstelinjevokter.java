public class Forstelinjevokter implements Runnable {
    String mistenkeligPerson;
    MistenkeligePersoner monitor;
    Flygning flygning;

    Forstelinjevokter(String mistenkeligPerson, MistenkeligePersoner monitor, Flygning flygning){
        this.mistenkeligPerson = mistenkeligPerson;
        this.monitor = monitor;
        this.flygning = flygning;
    }

    @Override 
    public void run(){
        for (Sete sete: flygning){
            Passasjer temp = sete.person;
            if(temp != null){
                int farlighetNr = Stringhjelper.inneholder(temp.navn, mistenkeligPerson);

                System.out.println(temp.navn + " har farglighet paa " + farlighetNr);

                if (farlighetNr > -1) monitor.leggTil(temp, farlighetNr);
            }
        }
    }
}
