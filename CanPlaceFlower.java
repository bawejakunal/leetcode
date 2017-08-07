// https://leetcode.com/problems/can-place-flowers/description/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n < 1)
            return true;
        int i = 0;
        while (n > 0 && i < flowerbed.length) {
            Boolean cond = (flowerbed[i] == 0);
            if (cond && i > 0) {
                cond = cond && flowerbed[i-1] == 0 && 
                    (i == flowerbed.length - 1 || flowerbed[i+1] == 0);
            }
            else if (cond){
                cond = cond && (flowerbed.length == 1 || flowerbed[i+1] == 0);
            }
            
            if (cond) {
                n--;
                flowerbed[i] = 1;
            }
            i++;
        }
        return n == 0;
    }
}