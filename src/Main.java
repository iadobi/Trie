import datenstrukturklassen.linear.List;

/**
 * Created by Stas on 24.06.2017.
 */
public class Main {

    void drawLine(int length){

    }

    public static void main(String [] args){
        /*
        * Tests
        * */

       //neuer Trie wird erstellt
        Trie t= new Trie();
        System.out.println("\nNeuer Trie wurde erstellt\n\n");


        //Linie zeichnen
        System.out.println("\n______________________________________________\n");


        //Trie wird mit Inhalten gefüllt
        t.addWord("Katze");
        t.addWord("Katzenzunge");
        t.addWord("Kater");
        t.addWord("Regenwurmnotaufnahme");
        t.addWord("Regen");
        t.addWord("Aufnahme");
        t.addWord("notaufnahme");
        t.addWord("Notfall");
        System.out.println("Trie wurde mit Inhalten befüllt");


        //Linie zeichnen
        System.out.println("\n______________________________________________\n");

        System.out.println("Suche nach dem Wort Notfall (es existiert)\n");
        boolean b=t.findWord("Notfall");
        if(b)
            System.out.println("Das Wort Notfall wurde gefunden\n");
        else
            System.out.println("Das Wort existiert nich in dem Trie\n");


        System.out.println("Suche nach dem Wort Zunge (es existiert nicht)\n");
        b=t.findWord("Zunge");
        if(b)
            System.out.println("Das Wort Zunge wurde gefunden\n");
        else
            System.out.println("Das Wort existiert nich in dem Trie\n");



        //Linie zeichnen
        System.out.println("\n______________________________________________\n");



        List<String> allWords = new List<>();
        allWords=t.getAllWords();
        allWords.toFirst();
        System.out.println("\nHier eine Liste aller Wörter im Trie:\n");
        while(allWords.hasAccess()) {
            System.out.println(allWords.getContent() + "\n");
            allWords.next();
        }

        //Linie zeichnen
        System.out.println("\n______________________________________________\n");


        System.out.println("\nHier eine Liste aller Wörter mit dem Prefix Ka\n");
        List<String> prefixWords = new List<>();
        prefixWords=t.findWords("Ka");
        prefixWords.toFirst();
        while(prefixWords.hasAccess()) {
            System.out.println(prefixWords.getContent() + "\n");
            prefixWords.next();
        }

        //Linie zeichnen
        System.out.println("\n______________________________________________\n");


        System.out.println("\nNun wird ein langes Wort (Regenwurmnotaufnahme) gelöscht um zu prüfen ob die kürzeren (Regen) erhalten bleiben\n");
        t.deleteWord("Regenwurmnotaufnahme");
        allWords=t.getAllWords();
        allWords.toFirst();
        System.out.println("\nHier eine Liste aller Wörter im Trie:\n");
        while(allWords.hasAccess()) {
            System.out.println(allWords.getContent() + "\n");
            allWords.next();
        }


        //Linie zeichnen
        System.out.println("\n______________________________________________\n");

        System.out.println("\nNun wird ein kurzes Wort (Katze) gelöscht um zu prüfen ob die längeren (Katzenzunge) erhalten bleiben\n");
        t.deleteWord("Katze");
        allWords=t.getAllWords();
        allWords.toFirst();
        System.out.println("\nHier eine Liste aller Wörter im Trie:\n");
        while(allWords.hasAccess()) {
            System.out.println(allWords.getContent() + "\n");
            allWords.next();
        }


        //Linie zeichnen
        System.out.println("\n______________________________________________\n");




    }
}
