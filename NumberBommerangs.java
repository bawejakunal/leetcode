// https://leetcode.com/problems/number-of-boomerangs




// Brute Force
// public class Solution {
    
//     private double distance(int []x, int []y) {
//         return Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1];
//     }
    
//     public int numberOfBoomerangs(int[][] points) {
//         int count = 0;
//         for (int i = 0; i < points.length - 2; i++) {
//             for (int j = i+1; j < points.length - 1; j++) {
//                 for (int k = j+1; k < points.length; k++) {
//                     double dij = distance(points[i], points[j]);
//                     double djk = distance(points[j], points[k]);
//                     double dik = distance(points[i], points[k]);
//                     if (dij == dik)
//                         count += 2;
//                     if (djk == dij)
//                         count += 2;
//                     if (djk == dik)
//                         count += 2;
//                 }
//             }
//         }
//         return count;
//     }
// }