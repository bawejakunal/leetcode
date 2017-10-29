// https://leetcode.com/problems/word-ladder/description/

class Solution {
    
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<String>(wordList);
        // source node is also counted in this problem
        // otherwise transform = #edges i.e 1 less
        int transform = 1;
        Queue<String> q = new LinkedList<String>();
        
        q.add(beginWord);
        while(!q.isEmpty()) {
            int qSize = q.size();
            while (qSize-- > 0) {
                String next = q.poll();
                for (int i = 0; i < next.length(); i++) {
                    String prefix = next.substring(0, i);
                    String suffix = next.substring(i + 1);
                    for (int a = 0; a < this.ALPHABET.length(); a++) {
                        char c = this.ALPHABET.charAt(a);
                        String possible = prefix + c + suffix;
                        if (dictionary.contains(possible)) {
                            if (possible.equals(endWord))
                                return ++transform; // stop searching, 1 more edge is traversed
                            q.add(possible);
                            dictionary.remove(possible);    // visited node
                        }
                    }
                }
            }
            transform++;
        }
        return 0;
    }
}