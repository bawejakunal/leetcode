// https://leetcode.com/problems/max-points-on-a-line/description/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    
    private int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private String getSlope(Point a, Point b) {
        int Y = b.y - a.y;
        int X = b.x - a.x;
        
        // Ensure a != b for below hacks to work
        // basically either it should be a vertical
        // line or a horizontal line and a and b
        // should be distinct points
        
        // hack for horizontal line point
        if (Y == 0)
            X = 1;
        
        // hack for vertical line point
        if (X == 0)
            Y = 1;
        
        // follow convention of -ve numerator
        // and +ve denominator so that -1/2 is same as 1/-2
        // for considering lines with same slopes
        if ((X < 0 && Y > 0) || (X < 0 && Y < 0)) {
            X = -X;
            Y = -Y;
        }
        
        // gcd can be calculated only for +ve numbers
        int g = gcd(Math.abs(X), Math.abs(Y));
        Y /= g;
        X /= g;
        
        return Y + " " + X;     // return slope as a pair of numerator, denominator
    }
    
    public int maxPoints(Point[] points) {
        if (points == null)
            return 0;
        if (points.length <= 2)
            return points.length;
        
        // track line segements in hashmap
        Map<String, Integer> map = new HashMap<>();
        int maxpt = 2;
        
        for (int i = 0; i < points.length; i++) {
            int samePoint = 0;
            int currMax = 0;
        
            for (int j = i + 1; j < points.length; j++) {
                
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    samePoint++;
                
                else {
                    String coeff = getSlope(points[i], points[j]);
                    map.put(coeff, 1 + map.getOrDefault(coeff, 0));
                    currMax = Math.max(currMax, map.get(coeff));
                }
            }
            
            // currMax is count of maximum points[j] on a line passing through
            // points[i]. We still need to account for points[j] = points[i]
            // Also, up to this point we have take count of points[j] but the actual
            // number of points on a line should also include point[i] hence + 1
            maxpt = Math.max(maxpt, currMax + samePoint + 1);
            map.clear();    // clear slope->count map
        }
        return maxpt;
    }
}