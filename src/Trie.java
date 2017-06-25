import datenstrukturklassen.linear.List;

/**
 * Created by Stas on 23.06.2017.
 */
public class Trie {

    private TrieNode root;

    public Trie(){
        //ein Trie hat IMMER einen root
        root= new TrieNode();
    }

    public void addWord(String word){
        root.addWord(word);
    }

    public List getAllWords(){
        return root.getWords();
    }

    public List findWords(String prefix){
        return root.findWords(prefix);
    }

    public boolean findWord(String word){
        return root.findWord(word);
    }


    public void deleteWord(String word){
        if(!root.findWord(word)||word.length()==0){
            return;
        }
        else
            root.deleteWord(word);

    }

    public String toString(){
        String words="";
        List<TrieNode> list= new List<>();
        list=root.getWords();
        list.toFirst();
       while(list.hasAccess()){
           words+="\n";
           words+=list.getContent();
          list.next();
       }
       return words;


    }
}
