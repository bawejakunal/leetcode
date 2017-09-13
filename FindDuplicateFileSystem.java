// https://leetcode.com/problems/find-duplicate-file-in-system/description/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        List<List<String>> list = new LinkedList<List<String>>();
        
        HashMap<String, LinkedList<String>> contentMap = new HashMap<String, LinkedList<String>>();
        for (String path: paths) {
            String [] components = path.split(" ");
            String root = components[0];
            
            for (int i = 1; i < components.length; i++) {
                String filePath = root + "/" + components[i].substring(0, components[i].indexOf("("));
                String content = components[i].substring(components[i].indexOf("(") + 1, components[i].indexOf(")"));
            
                if (contentMap.containsKey(content))
                    contentMap.get(content).add(filePath);
                
                else {
                    LinkedList<String> contList = new LinkedList<String>();
                    contList.add(filePath);
                    contentMap.put(content, contList);
                }
                
            }
            
        }
        
        for (Map.Entry<String, LinkedList<String>> entry : contentMap.entrySet()) {
            if (entry.getValue().size() > 1)
                list.add(entry.getValue());
        }
        return list;
    }
}