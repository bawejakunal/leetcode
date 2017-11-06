// https://leetcode.com/problems/add-and-search-word-data-structure-design/description/

class WordDictionary {

    private WordDictionary[] arr;
    private boolean ends[];
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.arr = new WordDictionary[26];
        this.ends = new boolean[26];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;

        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] == null)
            this.arr[idx] = new WordDictionary();
        
        if (word.length() == 1)
            this.ends[idx] = true;  // word ends here
        else
            this.arr[idx].addWord(word.substring(1));    // insert suffix
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.isEmpty())
            return false;
        
        String suffix = word.substring(1);
        // any word search
        if (word.charAt(0) == '.') {
            for (int idx = 0; idx < 26; idx++) {
                // word continues ahead
                if (this.arr[idx] != null) {
                    // end of word
                    if (suffix.length() == 0 && this.ends[idx])
                        return true;
                    else if (this.arr[idx].search(suffix))
                        return true;
                }
            }
            return false;
        }
        
        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] != null) {
            if (word.length() > 1)
                return this.arr[idx].search(suffix);
            return this.ends[idx];  // if a word ends at this index
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
