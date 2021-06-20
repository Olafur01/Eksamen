import java.util.concurrent.CountDownLatch;

public class AnalyseTraad implements Runnable {
    AnalyseBuffer analyseBuffer;
    CountDownLatch cdl;//F

    AnalyseTraad(AnalyseBuffer analyseBuffer, CountDownLatch cdl){//F
        this.analyseBuffer = analyseBuffer;
        this.cdl = cdl; //F
    }

    @Override
    public void run() {
       while(true){
            try{
                Pasient temp = analyseBuffer.taUt();// F
                if(temp == null){   // F
                    cdl.countDown(); // F
                    return; // F
                }
                temp.kanHaSykdom(); // F
            }
            catch(InterruptedException e){
       }    
       }
    }
}
