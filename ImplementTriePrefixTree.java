// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {

    private Trie[] arr;
    private boolean ends[];
    
    /** Initialize your data structure here. */
    public Trie() {
        this.arr = new Trie[26];
        this.ends = new boolean[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;

        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] == null)
            this.arr[idx] = new Trie();
        
        if (word.length() == 1)
            this.ends[idx] = true;  // word ends here
        else
            this.arr[idx].insert(word.substring(1));    // insert suffix
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null)
            return false;
        if (word.isEmpty())
            return true;
        
        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] != null) {
            if (word.length() > 1)
                return this.arr[idx].search(word.substring(1));
            return this.ends[idx];  // if a word ends at this index
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        if (word == null)
            return false;
        if (word.isEmpty())
            return true;
        
        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] != null) {
            if (word.length() > 1)
                return this.arr[idx].startsWith(word.substring(1));
            return true;    // this is the last char of prefix
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */