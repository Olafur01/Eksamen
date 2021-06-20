public class Stringhjelper{
    
    static int inneholder(String s, String t){
        int sLen = s.length();
        int tLen = t.length();

        for (int i = 0; i < sLen - tLen; i++){
            boolean eq = true;
            for (int j = 0; j < tLen; j++){
                if(s.charAt(i+j) != t.charAt(j)){
                    eq = false;
                    break;
                }
            }  
            if (eq){
                return i;
            }   
        }
        return -1;
    }

    public static void main(String [] args){
        System.out.println(inneholder("STEIN", "N"));
        System.out.println("STEIN".indexOf("N"));
    }


}