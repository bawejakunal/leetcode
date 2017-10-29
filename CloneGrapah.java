// https://leetcode.com/problems/clone-graph/discuss/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    // DFS
    private UndirectedGraphNode cloneNode(HashMap<Integer, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        if (map.containsKey(node.label))
            return map.get(node.label);     // return the node clone
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(copyNode.label, copyNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneNode(map, neighbor));
        }
        return copyNode;
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return cloneNode(map, node);
    }


    // BFS
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if (node == null)
    //         return null;
        
    //     HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    //     Queue<UndirectedGraphNode> q = new LinkedList<>();
    //     UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    //     q.add(node);
    //     map.put(root.label, root);
        
    //     while (!q.isEmpty()) {
    //         UndirectedGraphNode nextNode = q.poll();
    //         for (UndirectedGraphNode neighbor: nextNode.neighbors) {
    //             // clone if not cloned already
    //             if (!map.containsKey(neighbor.label)) {
    //                 map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
    //                 q.add(neighbor);
    //             }
                
    //             // add as a neighbor
    //             map.get(nextNode.label).neighbors.add(map.get(neighbor.label));
    //         }
    //     }
    //     return root;
    // }
}