// https://leetcode.com/problems/permutations/description/

class Solution {
    
    private static List<List<Integer>> permute(int []nums, int idx) {
        List<List<Integer>> permutations;
        if (idx >= nums.length) {
            permutations = new LinkedList<List<Integer>>();
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }
        
        // generate sub permuatations
        permutations = permute(nums, idx + 1);
        
        List<List<Integer>> perms = new LinkedList<List<Integer>>();
        for (List<Integer> p : permutations) {
            for (int j = 0; j <= p.size(); j++) {
                List<Integer> c = new ArrayList<Integer>(p);
                c.add(j, nums[idx]);
                perms.add(c);
            }
        }
        return perms;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    // ITERATIVE
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> permutation;
    //     if (nums == null || nums.length < 1) {
    //         permutation = new LinkedList<List<Integer>>();
    //         return permutation;
    //     }
        
    //     Queue<List<Integer>> q1 = new LinkedList<List<Integer>>();
    //     Queue<List<Integer>> q2 = new LinkedList<List<Integer>>();
    //     List<Integer> first = new ArrayList<Integer>();
    //     first.add(nums[0]);
    //     q1.add(first);
        
    //     for (int j = 1; j < nums.length;j++) {
    //         while (!q1.isEmpty()) {
    //             List<Integer> p = q1.poll();
    //             for (int i = 0; i <= p.size(); i++) {
    //                 List<Integer> newPerm = new ArrayList<Integer>(p);
    //                 newPerm.add(i, nums[j]);
    //                 q2.add(newPerm);
    //             }
    //         }
    //         q1 = q2;
    //         q2 = new LinkedList<List<Integer>>();
    //     }
    //     permutation = (List) q1;
    //     return permutation;
    // }
}