// https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        
        // create priorityqueue
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>(10, new TupleComparator());
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            Tuple t = new Tuple(entry.getKey(), entry.getValue());
            q.add(t);
        }
        
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            for (int i = 0; i < t.freq; i++)
                builder.append(t.ch);
        }
        return builder.toString();
    }
}

class Tuple {
    Character ch;
    Integer freq;
    Tuple(Character ch, Integer freq) {
        this.ch = ch;
        this.freq = freq;
    }
}


class TupleComparator implements Comparator<Tuple> {
    @Override
    public int compare (Tuple a, Tuple b) {
        return b.freq - a.freq;
    }
}
