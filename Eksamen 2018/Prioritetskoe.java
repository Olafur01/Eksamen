public class Prioritetskoe<T> {
    private Node hode = null;
    private int teller = 0;


    public int antall(){
        return teller;
    }

    public void settInn(T inn, int prio){
        Node nyNode = new Node(inn, prio);
        teller++;
       
        if (hode == null){
            hode = nyNode;
        }
        else if (hode.prio <= nyNode.prio){
            nyNode.neste = hode;
            hode = nyNode;
        }
        else{
            Node temp = hode;
            // Invariant: temp.prio < ny.prio
            while (temp.neste != null && temp.neste.prio < nyNode.prio){
                temp = temp.neste;
            }
            nyNode.neste = temp.neste;
            temp.neste = nyNode;
        }
    }

    public T taUt(){
        if (hode == null){
            return null;
        }
        else{
            Node temp = hode;
            hode = temp.neste;
            teller--;
            return temp.data;
        }
    }
    

    private class Node{
        T data;
        Node neste;
        int prio;

        Node(T data, int prio){
            this.data = data;
            this.prio = prio;
        }
    }
}
