// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; // i -> j
        int[] outdegree = new int[numCourses];
    
        // construct graph
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph[course][prereq] = 1;  // course to prereq directed edge
            outdegree[course]++;    // one more immediate requirement
        }
    
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i < outdegree.length; i++) {
            if (outdegree[i] == 0)
                queue.add(i);   // can complete because no requisites
        }
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (graph[i][course] != 0) {
                    if (--outdegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        
        return count == numCourses;
    }

/*
    private boolean detectCycle(int[][] graph, int state[], int node) {
        state[node] = 1;    // start exploration
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                if (state[i] == 0 && detectCycle(graph, state, i))
                    return true;
                else if (state[i] == 1) // back edge on current dfs path
                    return true;
            }
        }
        state[node] = 2;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; // i -> j
        int[] state = new int[numCourses];  // 0 - unvisited, 1 - underexploration, 2 - completed
    
        // construct graph
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph[course][prereq] = 1;  // course to prereq directed edge
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (detectCycle(graph, state, i))
                    return false;
            }
        }
        
        return true;    // no cycles detected
    }
*/
}