// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> index = new HashMap<String, Integer>();
        int minIndexSum = Integer.MAX_VALUE;
        ArrayList<String> commonList = new ArrayList<String>();
        
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int indexSum = i + index.get(list2[i]);
                
                if (indexSum > minIndexSum)
                    continue;
                
                if (indexSum < minIndexSum) {
                    minIndexSum = indexSum;
                    while (!commonList.isEmpty())
                        commonList.remove(commonList.size()-1);
                    
                }
                commonList.add(list2[i]);
            }
        }
        return commonList.toArray(new String[commonList.size()]);
    }
}