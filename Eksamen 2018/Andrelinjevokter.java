

public class Andrelinjevokter implements Runnable {
    MistenkeligePersoner mistenkte;

    Andrelinjevokter(MistenkeligePersoner mistenkte){
        this.mistenkte = mistenkte;
    }

    @Override 
    public void run(){
        while (true){
        Passasjer temp = mistenkte.taUt();
        if (temp != null){
            Main.mistenkelig(temp);
        }
    }
    }
}
