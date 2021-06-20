/*Klassen	Sti	skal	ha	en	konstruktør	som	setter	stiens	lengde	(i	meter)	og	kryssene	stien	går	
mellom	–	dette	er	parametere	til	konstruktøren.	En	sti	må	inneholde	referanser	til	to	kryss,	
ett	i	hver	ende	av	stien.	En	sti	har	ingen	retning	og	det	er	OK	at	disse	endene	er	det	samme	
krysset,	da	blir	stien	bare	en	rundtur	i	skogen	tilbake	til	samme	kryss.			Når	vi	senere	skal	
simulere	at	det	går	personer	i	skogen,	må	vi	finne	ut	hvor	personen	ender	når	
vedkommende	starter	på	en	sti	som	går	ut	fra	et	krysset.		Skriv	derfor	en	metode	
finnAndreEnde	i	klassen	Sti	som,	gitt	det	ene	endepunktet	(krysset),	returnerer	det	andre	
endepunktet	av	stien.	Videre	skal	klassen	Sti	ha	en	metode	int	beregnGaaTid(int	fart)	som	
regner	ut	hvor	lang	tid	det	tar	å	gå	stien	med	den	oppgitte	farten	og	returnerer	resultatet.	
Farten	angis	i	meter	per	minutt,	og	gåtiden	returneres	i	hele	minutter.	Om	du	avrunder	eller	
fjerner	sifre	bak	komma	når	du	beregner	resultatet	spiller	ingen	rolle.
*/

class Sti {
    int lengde;
    Kryss startpunkt;
    Kryss endepunkt;

    Sti(int lengde, Kryss startpunkt, Kryss endepunkt){
        this.endepunkt = endepunkt;
        this.startpunkt = startpunkt;
        this.lengde = lengde;
    }

    Kryss finnAndreEnde(Kryss punkt){
        // Sjekker forst om dette er et punkt som enten er start eller endepunktet
        if(!punkt.equals(startpunkt) || !punkt.equals(endepunkt)) return null;
        // Hvis dette punktet er startpunktet saa returneres endepunktet 
        if(punkt.equals(startpunkt)) return endepunkt;
        // returnerer startpunktet ellers 
        return startpunkt;
        
    }

    int beregnGaaTid(int fart){
        // Returnerer tiden det gaar aa hele lengden av stien. Gjengir dette som 
        // et heltatt 
        return Math.round(this.lengde * fart);
    }


}
