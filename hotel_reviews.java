
class Trie {
    private Trie[] children;
    private boolean isEndOfWord;

    public Trie() {
        children=new Trie[26];
        isEndOfWord=false;
    }
    
    public void insert(String word) {
        Trie curr=this;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null)
                curr.children[index]=new Trie();
            curr=curr.children[index];
        }
        curr.isEndOfWord=true;
        
    }
    
    public boolean search(String word) {
          Trie curr=this;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null)
                return false;
            curr=curr.children[index];
        }
       return  curr.isEndOfWord;
        
    }
    
    public boolean startsWith(String prefix) {
           Trie curr=this;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(curr.children[index]==null)
                return false;
            curr=curr.children[index];
        }
return true;
        
    }
}
class Pair {
    int count;
    int index;

    Pair(int count, int index) {
        this.count = count;
        this.index = index;
    }
}
public class Solution {
    public ArrayList<Integer> solve(String a, ArrayList<String> b) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Pair[] pairs = new Pair[b.size()];

        Trie trie= new Trie();

        String[] words = a.split("_");
        int cnt=0;

        for(String word: words){
            trie.insert(word);
        }

        for(int i=0;i<b.size();i++){
            String[] tmp = b.get(i).split("_");
            cnt=0;
            for(String w: tmp){
                if(trie.search(w)){
                    cnt+=1;
                }
            }
            pairs[i] = new Pair(cnt,i);

        }
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.index - o2.index;
            }
            return o2.count - o1.count;

        });

        for (int i = 0; i < pairs.length; i++) {
            result.add(pairs[i].index);
        }
        return result;
    }
}
