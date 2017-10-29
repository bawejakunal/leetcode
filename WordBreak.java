// https://leetcode.com/problems/word-break/description/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean []visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (set.contains(s.substring(start, end))) {
                        if (end == s.length())
                            return true;
                        q.add(end);
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}