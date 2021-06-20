class Spiller implements Comparable<Spiller> {
    private String navn;
    protected Brukergrensesnitt ui;
    private int formue;
    protected Sted posisjon;
    private Skattekiste ryggsekk;
    private final static int MAX_PAA_RYGGEN = 5;
    private String [] svar = {"Ja", "Nei"};
    protected String spoersmaal;
    protected int valg;
    protected String [] alternativer;

    public Spiller(String navn, Brukergrensesnitt ui, Sted start){
        this.navn = navn;
        this.ui = ui;
        posisjon = start;
        formue = 100;
        
    }









    @Override
    public int compareTo(Spiller o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
