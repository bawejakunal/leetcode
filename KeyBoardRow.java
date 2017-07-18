// https://leetcode.com/problems/keyboard-row/#/description


import java.util.regex.*;

public class Solution {
    public String[] findWords(String[] words) {
        Pattern p = Pattern.compile("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+|^$");
        ArrayList<String> wordList = new ArrayList<String>();
        for (String word: words) {
            Matcher m = p.matcher(word.toLowerCase());
            if (m.matches())
                wordList.add(word);
        }
        return wordList.toArray(new String[wordList.size()]);
    }
}