// https://leetcode.com/problems/queue-reconstruction-by-height
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][];
        for (int []person: people) {
            // insert person at person[1] index if nobody stands there already
            if (queue[person[1]] == null)
                queue[person[1]] = person;
            else {
                int idx = person[1];
                int cnt = 0;
                // locate the idx where person should next be placed i.e skip all the people taller
                // than person, already standing in the queue
                while (queue[idx] != null && cnt < person[1] && ((queue[idx][0] > person[0]) || 
                      (queue[idx][0] == person[0] && person[1] > queue[idx][1]))) {
                    idx++;
                    cnt++;
                }
                int next = idx;
                
                // locate the last index for people after idx i.e shorter people
                while (queue[next] != null)
                    next++;
                
                // right shift shorter people by 1
                while (next > idx) {
                    queue[next] = queue[next - 1];
                    next--;
                }
                
                // insert the person at correct index
                queue[next] = person;
            }
        }
        return queue;
    }
}