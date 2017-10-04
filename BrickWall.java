// https://leetcode.com/problems/brick-wall/description/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        // calculate wall width
        int wallWidth = 0;
        for (Integer width : wall.get(0))
            wallWidth += width;
        
        // fill hashmap
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (List<Integer> row : wall) {
            int total = 0;
            for (Integer width: row) {
                total += width;
                if (total == wallWidth)
                    break;
                counts.put(total, 1 + counts.getOrDefault(total, 0));
            }
        }
        
        // count max number of walls skipped
        int skipped = 0;
        for (Integer k : counts.keySet()) {
            skipped = Math.max(skipped, counts.get(k));
        }
        
        // minimum bricks crossed = rows - maxSkipped
        return wall.size() - skipped;
    }
}