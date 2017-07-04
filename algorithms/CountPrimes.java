// https://leetcode.com/problems/count-primes/#/description

public class Solution {
    public int countPrimes(int n) {
        int []primes = new int[n];
        int i = 2, cnt = 0;
        while (i < n){
            boolean isPrime = true;
            int root = (int)Math.sqrt((double)i);
            for (int j = 0; j < cnt;j++) {
                if (primes[j] > root)
                    break;
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primes[cnt++] = i;
            i++;
        }
        return cnt;
    }
}
