public class Seterad {
    int radNr;
    Sete[] seter;

    Seterad(String radInfo){
        String [] data = radInfo.split(":");
        radNr = Integer.parseInt(data[0]);

        //Foerst hvilke seter har vi 
        String info = data[1];
        String sTab = "";
        for (int i = 0; i < info.length(); i++){
            char c = info.charAt(i);
            if ('A' <= c && c <= 'Z'){
                sTab += c;
            }
        }

        //Sjekk hvilke type seter vi har
        seter = new Sete[sTab.length()];
        int seteIx = 0;
        for (int i = 0; i < info.length(); i++){
            char c = info.charAt(i);
            if ('A' <= c && c <= 'Z'){
                if(i < info.length()-1 && info.charAt(i+1) == '+'){
                    seter[seteIx++] = new GodBenplassSete(radNr, c);
                }
                else{
                    seter[seteIx++] = new Sete(radNr, c);
                }
            }
        }
        //Markerer hvilke seter som er midtgangseter
        seteIx = 0;
        for (int i = 0; i < info.length(); i++){
            char c = info.charAt(i);
            if(c == '*'){
                if (seteIx > 0) seter[seteIx-1].venstreForMidtgang = true;
                if (seteIx < seter.length) seter[seteIx].hoeyreForMidtgang = true;
            }
            else if ('A' <= c &&  c <='Z'){
                seteIx++;
            }
        }

        //Markerer vidusetene
        seter[0].erVindusete = seter[seter.length-1].erVindusete = true;
    }

    boolean bookPassasjer(Passasjer pas){
        for (int i = 0; i < seter.length; i++){
            if(seter[i].person == null){
                seter[i].person = pas;
                return true;
            }
        }
        return false;
    }

    boolean book(Passasjer pas, boolean foretrekkerVindu, boolean foretrekkerMidtgang){
        for (int i = 0; i < seter.length; i++){
            Sete temp = seter[i];
            if(temp.person == null){
                if(foretrekkerMidtgang && !temp.erVedMidgang()) continue;
                if(foretrekkerVindu && ! temp.erVindusete()) continue;
                if(pas.harLangeBen() && temp.passerForLangeBein()) continue;
                temp.person = pas;
                return true;
            }
        }
        return false;
    }

    boolean book(Passasjer pas1, Passasjer pas2){
        for(int i = 1; i < seter.length; i++){
            if (seter[i].person == null && seter[i-1].person == null && !seter[i].hoeyreForMidtgang){
                seter[i].person = pas1;
                seter[i-1].person = pas2;
                return true;
            }
        }
        return false;
    }

}
