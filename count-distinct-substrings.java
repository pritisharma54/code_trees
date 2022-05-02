//https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?leftPanelTab=0
//for each prefix starting at each index insert in tree,the no of nodes is equal to count of distinct substrings
//Each root to node path of a Trie represents a prefix of words present in Trie. Here we words are suffixes. So each node represents a prefix of suffixes.
//Every substring of a string “str” is a prefix of a suffix of “str”.
class TrieNode 
{
    public TrieNode []children = new TrieNode[26];
    TrieNode() 
    {
        for (int i = 0; i < 26; i++) 
        {
            children[i] = null;
        }
    }
}

public class Solution 
{
    //    Function to insert a string into the trie.
    private static void insert(String s, int i, TrieNode head) 
    {
        TrieNode temp = head;
        int n = s.length();

        //    Iterate through the given string
        while (i < n) 
        {
            char ch = s.charAt(i);

            //    If child node is not present.
            if (temp.children[ch - 'a'] == null) 
            {
                //    Create new child node.
                temp.children[ch - 'a'] = new TrieNode();
            }

            //    Move to the child node.
            temp = temp.children[ch - 'a'];
            i++;
        }
    }

    //    Function to count the number of nodes in the trie.
    private static int countNodes(TrieNode root) 
    {
        if (root == null) 
        {
            return 0;
        }

        int subTreeNodes = 1;

        //    Iterate through the children of the current node.
        for (int i = 0; i < 26; i++) 
        {
            subTreeNodes += countNodes(root.children[i]);
        }

        return subTreeNodes;
    }

    public static int countDistinctSubstrings(String s) 
    {
        int n = s.length();

        //    Intialize the root of  the trie.
        TrieNode head = new TrieNode();

        //    Insert all suffixes into the trie.
        for (int i = 0; i < n; i++) 
        {
            insert(s, i, head);
        }

        //    Count the total number of nodes in the trie.
        int totalNodes = countNodes(head);

        //    Return the number of distinct substrings.
        return totalNodes;
    }
}
