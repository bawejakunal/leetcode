// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
//             @Override
//             public int compare(Integer a, Integer b) {
//                 return b - a;
//             }
//         });
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 if (heap.size() < k || matrix[i][j] <= heap.peek()) 
//                     heap.add(matrix[i][j]);
//                 if (heap.size() > k)
//                     heap.poll();
//             }
//         }
//         return heap.peek();
//     }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        for (int j = 0; j < matrix[0].length; j++)
            heap.add(new Tuple(0, j, matrix[0][j]));    // add first row to heap
        
        // pop k-1 min elements from heap
        for (int i = 1; i < k; i++) {
            Tuple t = heap.poll();
            if (t.row == matrix.length - 1)
                continue;   // go to some other column
            heap.add(new Tuple(t.row + 1, t.col, matrix[t.row + 1][t.col]));
        }
        
        // pop kth minimum element
        return heap.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int row, col, val;
    Tuple (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    
    public int compareTo(Tuple other) {
        return this.val - other.val;
    }
}