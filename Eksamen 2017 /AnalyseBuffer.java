import java.util.LinkedList;
import java.util.concurrent.locks.*;


class AnalyseBuffer {
    Lock laas = new ReentrantLock();
    LinkedList<Pasient> beholder = new LinkedList<>();
    Condition ikketom = laas.newCondition();
    boolean kommerFlere = true; // F
    
    void settInn(Pasient p) throws InterruptedException{
        laas.lock();
        try{
            beholder.add(p);
            ikketom.signalAll();
        }
        finally{
            laas.unlock();
        }
    }

    Pasient taUt() throws InterruptedException{
        laas.lock();
        try{
            while(beholder.isEmpty() && kommerFlere){// F
                ikketom.await(); // F
            }
            if (beholder.isEmpty()){ // F
                return null; // F
            }
            return beholder.removeFirst();
        }
        finally{
            laas.unlock();
        }   
    }
}
