// https://leetcode.com/problems/implement-magic-dictionary/discuss/

class MagicDictionary {

    private HashSet<String> dictionary;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.dictionary = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dictionary = new HashSet<String>(Arrays.asList(dict));
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char)((int)'a' + j);
                if (c == word.charAt(i))
                    continue;
                String newWord = word.substring(0, i) + c + word.substring(i+1);
                if (this.dictionary.contains(newWord))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */