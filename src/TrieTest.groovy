import datenstrukturklassen.linear.List

/**
 * Created by Stas on 24.06.2017.
 */
class TrieTest extends groovy.util.GroovyTestCase {

    Trie t= new Trie();

    void fillTrie(){
        t.addWord("Katze");
        t.addWord("Katzenzunge");
        t.addWord("Kater");
        t.addWord("Regenwurmnotaufnahme");
        t.addWord("Regen");
        t.addWord("Aufnahme");
        t.addWord("notaufnahme");
        t.addWord("Notfall");
    }



    void testGetAllWords() throws Exception{
        fillTrie();
        List<String> erwarteteWerte= new List<>()
        erwarteteWerte.append("Katze");
        assertEquals("Liste der Worte", erwarteteWerte, t.allWords)
        assertEquals("Katze existiert in dem Trie",true, t.findWord("Katze"));
    }

    void testFindWords() {

    }

    void testFindWord() {
       // assertEquals("Adding word Katze",null, t.addWord("Katze"));
    }

    void testDeleteWord() {

    }

    void testToString() {

    }
}
