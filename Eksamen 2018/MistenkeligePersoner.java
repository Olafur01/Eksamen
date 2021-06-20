import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.*;

public class MistenkeligePersoner {
    Prioritetskoe<Passasjer> mistenkeligPersoner = new Prioritetskoe<>();
    Lock laas = new ReentrantLock();
    Condition tom = laas.newCondition();
    


    public void leggTil(Passasjer mistenkelig, int farelighetsNr){
        laas.lock();
        try{
            mistenkeligPersoner.settInn(mistenkelig, farelighetsNr);
            tom.signalAll();
        }
        finally{
            laas.unlock();
        }
    }

    public Passasjer taUt(){
        laas.lock();
        try{
            while (mistenkeligPersoner.antall() == 0){
                tom.await();
            }
            Passasjer temp = mistenkeligPersoner.taUt();
            return temp;
        }
        catch (InterruptedException e){
            System.out.println("Fikk ikke tatt ut mistenkelig person til andre gangs vokter");
        }
        finally {
            laas.unlock();
        }
    return null;
    }
  
}
