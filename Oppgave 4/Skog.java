/*Klassen	Skog	skal	ha	en	konstruktør	som	bygger	opp	datastrukturen	av	stier	og	kryss.	Det	
skal	være	ANTSTIER	stier	og	ANTKRYSS	kryss	og	disse	konstantene	skal	settes	av	klassens	
konstruktør.		Klassen	Skog	skal	inneholde	en	array	som	peker	på	alle	kryssene.	Konstruktøren	
i	Skog	bygger	opp	datastrukturen	som	følger:	Opprett	alle	kryssene,	foreløpig	uten	stier,	og	
legg	disse	i	arrayen	for	alle	kryss.	Opprette	deretter	alle	stiene.	For	hver	sti	som	opprettes	
trekkes	to	tilfeldige	kryss	stien	skal	gå	mellom,	type	sti	og	lengde.	
*/
import java.util.ArrayList;
import java.util.Random;

class Skog {
    final int ANTSTIER;
    final int ANTKRYSS;
    Kryss [] kryssISkogen;
    boolean [] besoekte;

    Skog(int stier, int kryss){
        this.ANTKRYSS = kryss;
        this.ANTSTIER = stier;

        kryssISkogen = new Kryss[ANTKRYSS];

        int teller = 0;
        // Oppretter alle kryss uten noen stier 
        // Oppretter en invariant, der vi gjennomfoerer alt dette til hvert kryss har blitt opprettet
        while(teller != ANTKRYSS){
            ArrayList<Sti> stierIKryss = new ArrayList<>();
            Kryss etKryss = new Kryss(stierIKryss);
            kryssISkogen[teller] = etKryss;
            teller++;
        }


        int lengde;
        int stoerstLengde = 2500;
        int minsteLengde = 220;
        Kryss kryss1 = null;
        Kryss kryss2 = null;
        int kryssIx = kryssISkogen.length - 1;
        // Oppretter en random variable slik at alle faar trykket tilfeldige verdi av lengde, og start og slutt
        // kryss
        Random rand = new Random();
        teller = 0;
        while (teller != ANTSTIER){
            boolean fortsett = true;
            int antallGanger = 0;
            while(fortsett && antallGanger < 100){
            // Oppretter alle variablene for hver sti i en skog. 
            kryss1 = kryssISkogen[rand.nextInt(kryssIx)];
            kryss2 = kryssISkogen[rand.nextInt(kryssIx)];
                // Hvis vi har gaatt gjennom dette 100 ganger saa finnes det ikke noe vei og vi 
                // avslutter programmet 
                if(antallGanger >= 100){
                    System.out.println("Det finnes ikke noe tilfredstillende siter");
                    break;
                }
            fortsett = kryss1.finnesVeiTil(kryss2);
            antallGanger++;
            }
            
            // Avslutter hele programmet hvis det ikke har blitt funnet en tilfredstillende utgang. 
            if(fortsett){
                break;
            }

            lengde = Trekk.trekk(minsteLengde, stoerstLengde);
            

            // Oppretter en 25% sjanse for hver av mulighetene
            int hvilkenTypeSti = Trekk.trekk(0, 3);
            // Lik sjansje for hvilke utsiktsverdi den faa
            int utsiktsVerdi = Trekk.trekk(1, 6);

            Sti nySti = null;
            if(hvilkenTypeSti == 0){
                nySti = new Naturstier(lengde, kryss1, kryss2);
            }
            if(hvilkenTypeSti == 1){
                nySti = new GodUtsiktNatursti(lengde, kryss1, kryss2, utsiktsVerdi);
            }
            if(hvilkenTypeSti == 2){
                nySti = new GodUtsiktKjerrevei(lengde, kryss1, kryss2, utsiktsVerdi);
            }
            if(hvilkenTypeSti == 3){
                nySti = new Kjerrevei(lengde, kryss1, kryss2);
            }


            // Legger til stiene til kryssene som er endepunkt og startpunktet for krysset 
            kryss1.addSti(nySti);
            kryss2.addSti(nySti);
        }



    }

    Kryss hentTilfeldigKryss(){
        Random rand = new Random();
        // Vil unnga IndexOutOfBounds, for hvis en tar indeksen paa det lengste 
        int antallKryss = kryssISkogen.length - 1;
        return kryssISkogen[rand.nextInt(antallKryss)];
    }

    Kryss hentTilfeldigStart(){
        Random rand = new Random();
        // Vil unnga IndexOutOfBounds, for hvis en tar indeksen paa det lengste 
        int antallKryss = kryssISkogen.length - 1;
        Kryss returKryss = kryssISkogen[rand.nextInt(antallKryss)];
        // Sjkker om krysset er isolert eller ikke. Hvis det er det, sa velges et nytt kryss 
        while(returKryss.erIsolert()){
            returKryss = kryssISkogen[rand.nextInt(antallKryss)];
        }
        return returKryss;
    }
}
