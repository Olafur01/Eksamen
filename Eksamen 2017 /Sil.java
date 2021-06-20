import java.util.concurrent.CountDownLatch; // F

class Sil implements Runnable{
    PasientPrio pasientPrio;
    AnalyseBuffer analyseBuffer;
    int prioNr;
    CountDownLatch teller; //F 

    Sil(PasientPrio pasientPrio, AnalyseBuffer analyseBuffer, int prioNr, CountDownLatch cdl){ //F
        this.pasientPrio = pasientPrio;
        this.analyseBuffer = analyseBuffer;
        this.prioNr = prioNr;
        teller = cdl; // F
    }

    @Override
    public void run() {
        Pasient temp = pasientPrio.hentUt(prioNr);
        while(temp != null){
            if (temp.erIFaresone()){
                try{
                    analyseBuffer.settInn(temp);
                }
                catch (InterruptedException e){
                }
            }
            temp = pasientPrio.hentUt(prioNr);
        }
        teller.countDown(); // F   
    }
    
}
