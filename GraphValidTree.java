// https://leetcode.com/problems/graph-valid-tree/description/

class Solution {
    
    boolean dfs(int[][] graph, int node, boolean []visited, int []parent) {
        visited[node] = true;   // mark node as seen
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                if (visited[i] && parent[node] != i)
                    return false;   // cycle detected
                else if (visited[i] == false) {
                    parent[i] = node;
                    if (!dfs(graph, i, visited, parent))
                        return false;
                }
            }
        }
        return true;    // dfs complete from node
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || n == 0)
            return false;    // empty tree or graph
        
        int graph[][] = new int[n][n];
        for (int []edge: edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;  // undirected edges
        }
        
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];
        parent[0] = -1; // parent node in dfs traversal
        if (!dfs(graph, 0, visited, parent))
            return false;   // cycle detected so not a tree
        for (boolean v: visited)
            if (v == false)
                return false;   // disconnected graph so not a tree
        return true;
    }
}