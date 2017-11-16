// https://leetcode.com/problems/word-search-ii/description/

class Solution {
    
    private void findWords(char[][] board, int row, int col, Trie dict,
                           List<String> words, StringBuilder sb) {
        
        // already visited
        if (board[row][col] == '-')
            return;
        
        char c = board[row][col];
        sb.append(c);
        
        // if a valid word can be discovered
        if (dict.startsWith(sb.toString())) {
            board[row][col] = '-';   //mark as visited
            if (dict.search(sb.toString())) {
                words.add(sb.toString());
                dict.remove(sb.toString());     // deduplication
            }
            if (row > 0)
                findWords(board, row - 1, col, dict, words, sb);
            if (row < board.length - 1)
                findWords(board, row + 1, col, dict, words, sb);
            if (col > 0)
                findWords(board, row, col - 1, dict, words, sb);
            if (col < board[row].length - 1)
                findWords(board, row, col + 1, dict, words, sb);
        }
            
        board[row][col] = c;    // backtrack
        sb.deleteCharAt(sb.length() - 1);
    }
    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordlist = new LinkedList<>();
        if (board != null && board.length > 0) {
            
            Trie trie = new Trie();
            for (String word: words)
                trie.insert(word);
            
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[i].length; j++)
                    findWords(board, i, j, trie, wordlist, new StringBuilder());
        }
        return wordlist;
    }
}

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
        
        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] != null) {
            if (word.length() > 1)
                return this.arr[idx].startsWith(word.substring(1));
            return true;    // this is the last char of prefix
        }
        return false;
    }
    
    public void remove(String word) {
        if (word.isEmpty())
            return;
        int idx = word.charAt(0) - 'a';
        if (this.arr[idx] != null) {
            if (word.length() > 1) {
                this.arr[idx].remove(word.substring(1));
            } else {
                this.ends[idx] = false;
            }
        }
    }
}
