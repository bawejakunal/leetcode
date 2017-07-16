// https://leetcode.com/problems/intersection-of-two-arrays-ii

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList <Integer> arr = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (j < nums2.length) {
                while (i < nums1.length && nums1[i] < nums2[j])
                    i++;
            }
            
            if (i < nums1.length) {
                while (j < nums2.length && nums2[j] < nums1[i])
                    j++;
            }
            
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int x[] = new int[arr.size()];
        for (i=0; i < arr.size(); i++) {
            x[i] = arr.get(i);
        }
        return x;
    }
}