class Tidspunkt implements Comparable<Tidspunkt>{
    int aar, mnd, dag, time, min, sek;

    Tidspunkt(int aar, int mnd, int dag, int time, int min, int sek){
        this.aar =aar;
        this.mnd = mnd;
        this.dag = dag;
        this.time = time;
        this.min = min;
        this.sek = sek;
    }


    @Override 
    public int compareTo(Tidspunkt t){
        if(aar != t.aar) return aar - t.aar;
        if(mnd != t.mnd) return mnd - t.mnd;
        if(dag != t.dag) return dag - t.dag;
        if(time != t.time) return time - t.time;
        if(min != t.min) return min - t.min;
        return sek - t.sek;
    }

    @Override 
    public String toString(){
        return time + ":" + min + ":" + sek + " - " + dag + "/" + mnd + "/" + aar;
    }
}