import datenstrukturklassen.linear.List;

/**
 * Created by Stas on 23.06.2017.
 */
public class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private boolean isLeaf;     //Quick way to check if any children exist
    private boolean isWord;     //Does this node represent the last character of a word
    private char character;
    private static Alphabet alphabet;



    /**
     * Konstruktor für den Root Node, da dieser keinen Buchstaben hat
     */
    public TrieNode()
    {
        alphabet= new Alphabet();
        children = new TrieNode[alphabet.getLength()];
        isLeaf = true;
        isWord = false;
    }

    /**
     * Konstruktor für die Kinder Nodes, da diese immer ienen Buchgstaben haben müssen
     */
    public TrieNode(char character)
    {
        this();
        this.character = character;
    }

    public boolean hasChildren(){
        for(int i=0;i<children.length;i++){
            if(children[i]!=null)
                return true;
        }
        return false;
    }

    public void addWord(String word){
        if(word.isEmpty()||word==null){
            return;
        }
        this.isLeaf=false;

        //position des char im Alphabet auslesen
        int charPos = alphabet.getPositionOfChar(word.charAt(0));
        if(charPos==-1)
            System.out.println("Buchstabe nicht im Alphabet enthalten");

        //wenn das Kinder Array an dieser Position noch nichts gespeichert hat - Der Buchstabe also nicht in diesem existiert
        if(children[charPos]==null){
            //erstelle neuen TrieNode mit dem Buchstaben und füge ihn an diese Stelle ein
            children[charPos]=new TrieNode(word.charAt(0));
            //speichere im gerade erstellten Kind-Node eine Referenz auf das Parent - also this
            children[charPos].parent=this;
        }

        //Wenn das Wort mehr als einen Buchstaben hat
        if(word.length()>1){
           //füge den Rest des Strings OHNE den ersten Buchstaben in den eben erstellten KindKnoten ein
            children[charPos].addWord(word.substring(1));
        }
        //das Wird so lange rekursiv gemacht, bis der String leer ist
        //in dem Fall wissen wir: wir sind am letzten Buchstaben, also am Untersten Node des Wortes angekommen - daher:
        else{
            children[charPos].isWord=true;
        }

    }


// Gibt eine Liste aller Wörter mit einem bestimmten Präfix zerück
public List findWords(String prefix){
    List<String> words = new List<>();
        if(prefix.length()==0) {
            words=this.getWords();
            words.toFirst();
            while (words.hasAccess()){
                words.setContent(prefix+words.getContent());
                words.next();
            }
            return words;
        }
    else
            return children[alphabet.getPositionOfChar(prefix.charAt(0))].findWords(prefix.substring(1));


}


//da es nicht sinnvoll ist bei der Suche nach einem Wort, das selbe Wort zurückzuliefern, wird diese funktion einen boolischen Wert zurückliefern
    //true wenn das Wort gefunden wurde und false wenn nicht
public boolean findWord(String word){
    if (word.length()==0){
        if(this.isWord)
            return true;
        else return false;
    }
    else if(this.children[alphabet.getPositionOfChar(word.charAt(0))]==null)
        return false;
    else
        return children[alphabet.getPositionOfChar(word.charAt(0))].findWord(word.substring(1));

}



//Gibt eine Liste aller Wörter zurück
 public List getWords(){
        List<String> words = new List<>();

        //wenn es ein Wort ist, so sind wir gerade am letzten Knoten
        //daher wird für diesen toString aufgerufen.
        //to String arbeitet sich rekursiv nach oben zum Parent hoch und fügt dann immer nach und nach die Kinder zum String hinzu, wodurch das Word entsteht
        //dieses wird dann in die Liste eingefügt
        if(isWord)
            words.append(this.toString());

        if(!isLeaf){
            for(int i=0;i<children.length;i++){
                if(children[i]!=null){
                    //hier wird wieder rekursiv gearbeitet:
                    //falls es das child Element an der Stelle i gibt, wird für dieses nochmals die Methode getWords aufgerufen
                    //wenn man dann "unterwegs" auf isWord trifft wird (s.o.) das word angefügt
                    //das wird für jedes child Element geprüft
                    words.concat(children[i].getWords());
                }
            }
        }
        return words;

 }


 public void deleteWord(String word){
     //2. wenn wir ganz unten sind prüfen wir:
     if(word.length()==0){
         //ob der letzte Knoten des Wortes wirklich ein existierendes Wort ist
         //und ob es ein Blatt ist
         if(this.isWord&&this.isLeaf){
             //dann löschen wir den Node in dem wir uns gerade befinden:
            this.parent.children[alphabet.getPositionOfChar(this.character)]=null;

             if(!this.parent.hasChildren())
                 this.parent.isLeaf=true;
         }
         //wenn es ein Wort ist aber kein Blatt, entfernen wir lediglich das Flag
         else if(this.isWord){
             this.isWord=!this.isWord;
         }
     }


     else {
         //1. wir gehen rekursiv auf die unterste ebene
         children[alphabet.getPositionOfChar(word.charAt(0))].deleteWord(word.substring(1));
         //3. beim "hochgehen" von der Rekursion prüfen wir jedes Element ob es ein Blatt ist .  wenn ja, wird es gelöscht
         if(isLeaf) {
             if(this.isWord)
                 return;
             else {
                 this.parent.children[alphabet.getPositionOfChar(this.character)] = null;
                 if (!this.parent.hasChildren())
                     this.parent.isLeaf = true;
             }
         }
     }



 }

 public String toString(){
     if (parent==null)
         return "";
     return parent.toString()+String.valueOf(this.character);
 }



}
