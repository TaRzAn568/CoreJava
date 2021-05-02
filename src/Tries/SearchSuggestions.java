package Tries;
import java.util.*;


class Trie{
    LinkedHashMap<Character, Trie> next;
    boolean isEnd;

    Trie(){
        this.next = new LinkedHashMap<>();
        this.isEnd = false;
    }


    void insert(String s){

        Trie curr = this;
        for(char ch : s.toCharArray()){
            if(!curr.next.containsKey(ch)){
                curr.next.put(ch,new Trie());
            }
            curr = curr.next.get(ch);
        }
        curr.isEnd = true;
    }


    List<String> search(String s){
        // System.out.println("here s = "+s);

        Trie curr = this;
        for(int i=0; i<s.length(); i++){
            curr = curr.next.get(s.charAt(i));
            if(curr == null)
                break;
        }
        List<String> res = new ArrayList<>();
        if(curr != null)
            search(s,res, curr);
        return res;
    }

    void search(String s, List<String> res, Trie curr){

       if(res.size() >= 3){
           return;
       }
       if(curr.isEnd){
           res.add(s);
       }

       for(char ch : curr.next.keySet()){
           search(s + ch , res, curr.next.get(ch));
       }


    }
}

class SearchSuggestionsSolution {
    public List<List<String>> suggestedProducts(String[] products,  String sw) {

        Arrays.sort(products);
        Trie node = new Trie();

        for(String prod : products){
            node.insert(prod);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i=1; i<=sw.length(); i++){
            List<String> temp = node.search(sw.substring(0,i));
            res.add(new ArrayList<>(temp));
        }
        return res;

    }


}

class SearchSuggestions{

    public static void main(String[] ajd) {
        String[] prod = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";

        SearchSuggestionsSolution obj = new SearchSuggestionsSolution();

        System.out.println(obj.suggestedProducts(prod, searchWord));
    }
}