// https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    
    private boolean topologicalSort(int[][] graph, int course, Stack<Integer> stack, int []visited) {
        visited[course] = 1;    // started to explore
        
        for (int n = 0; n < graph[course].length; n++) {
            if (graph[course][n] == 1) {
                if (visited[n] == 1) {
                    return false;   // cycle detected, infeasible schedule
                }
                else if (visited[n] == 0) {
                    if (!topologicalSort(graph, n, stack, visited))
                        return false;   // a cycle detected
                }
            }    
        }
        
        stack.push(course);
        visited[course] = 2;    // finished dfs
        return true;    // no cycle detected
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][]graph = new int[numCourses][numCourses];
        for (int []req: prerequisites) {
            graph[req[1]][req[0]] = 1;
        }
        
        Stack<Integer> sortStack = new Stack<Integer>();
        int visited[] = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 &&
                !topologicalSort(graph, course, sortStack, visited))
                return new int[0];
        }
        
        for (int i = 0; i < numCourses; i++) {
            visited[i] = sortStack.pop();
        }
        return visited;
    }
}