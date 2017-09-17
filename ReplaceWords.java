// https://leetcode.com/problems/replace-words/description/

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        String []array = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (String root : dict) {
                if (array[i].startsWith(root)) {
                    array[i] = root;    // takes shortest always
                }
            }
            builder.append(array[i] + " ");
        }
        return builder.toString().trim();
    }
}