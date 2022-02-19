class Trie {
    private Trie[] children;
    private int count;
    private boolean isEndOfWord;

    public Trie() {
        children=new Trie[26];
        count=0;
        isEndOfWord=false;
    }

    public void insert(String word) {
        Trie curr=this;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(curr.children[index]==null) {
                curr.children[index] = new Trie();
                
            }
            curr.count+=1;

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

    public String search1(String key) {
        String res="";
        Trie curr=this;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c=key.charAt(i);
            res+=c;
            curr = curr.children[c - 'a'];
            if (curr.count == 1)
                break;
        }

        return res;
    }


}

public class Solution {
    public ArrayList<String> prefix(ArrayList<String> a) {
        int n = a.size();
        Trie tree = new Trie();

        for (int i = 0; i < n; i++) {
            tree.insert(a.get(i));
        }

        ArrayList<String> ans = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            ans.add(tree.search1(a.get(i)));
        }

        return ans;

    }
}
