/**
 * Created by Stas on 24.06.2017.
 */
public class Alphabet {
    private String alphabet;

   public Alphabet(){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }

    public String getAlphabet() {
        return alphabet;
    }

    public int getLength(){
       return alphabet.length();
    }

    public int getPositionOfChar(char c){
        for (int i=0;i<alphabet.length();i++){
            if(alphabet.charAt(i)==c)
                return i;
        }
        return -1;
    }
}
