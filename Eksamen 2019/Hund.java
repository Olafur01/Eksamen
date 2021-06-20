class Hund implements Comparable<Hund> {
    
    String navn;
    Kull mittKull;
    Tidspunkt minFodselstid;
    Hund neste = null;

    Hund(Kull k, String navn, Tidspunkt fodt) {
    this.navn = navn;
    mittKull = k;
    minFodselstid = fodt;
    }

    @Override
    public int compareTo(Hund h) {
        return this.minFodselstid.compareTo(h.minFodselstid);
    }

    public Hund mor() { 
        if(mittKull.mor != null) return mittKull.mor;
        return null;
    }

    public Hund far () {
        if(mittKull.far != null) return mittKull.far;
        return null;
    }
    public boolean erHelsosken(Hund h) {
        return mor() != null && far() != null && mor() == h.mor() && far() == h.far();
    }
    public boolean erHalvsosken(Hund h) {
        return (mor() != null && mor() == h.mor()) ||  (far() != null && far() == h.far() && !erHalvsosken(h));
    }

    public Hund finnEldsteKjenteOpphav() {
        if (mor() == null){
            if (far() == null){
                return this;
            }
            return far().finnEldsteKjenteOpphav();
        }
        if (far() == null){
            return mor().finnEldsteKjenteOpphav();
        }

        Hund morsiden = mor().finnEldsteKjenteOpphav();
        Hund farsiden = far().finnEldsteKjenteOpphav();

        if (morsiden.minFodselstid.compareTo(farsiden.minFodselstid) < 0){
            return morsiden;
        }
        else{
            return farsiden;
        }
    }
}
