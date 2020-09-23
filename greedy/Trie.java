package greedy;

public class Trie {
    public class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null){
            return;
        }
        TrieNode p = root;
        p.pass++;
        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++){
            int pathIndex = chs[i] - 'a';
            if(p.nexts[pathIndex] == null){
                TrieNode newNode = new TrieNode();
                p.nexts[pathIndex] = newNode;
                p = newNode;
            }else{
                p = p.nexts[pathIndex];
            }
            p.pass++;
        }
        p.end++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null){
            return false;
        }
        TrieNode p = root;
        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++){
            int pathIndex = chs[i] - 'a';
            if(p.nexts[pathIndex] == null){
                return false;
            }
            p = p.nexts[pathIndex];
        }
        return p.end != 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null){
            return false;
        }
        TrieNode p = root;
        char[] chs = prefix.toCharArray();
        for(int i = 0; i < chs.length; i++){
            int pathIndex = chs[i] - 'a';
            if(p.nexts[pathIndex] == null){
                return false;
            }
            p = p.nexts[pathIndex];
        }
        return true;
    }
}
