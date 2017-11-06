// https://leetcode.com/problems/accounts-merge/description/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                // construct graph of emails
                if (!graph.containsKey(email))
                    graph.put(email, new ArrayList<String>());
                graph.get(email).add(account.get(1));
                if (!graph.containsKey(account.get(1)))
                    graph.put(account.get(1), new ArrayList<>());
                graph.get(account.get(1)).add(email);
                
                // email to name mapping
                emailToName.put(email, name);
            }
        }

        // run dfs(iterative) to find conneted components of a graph
        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();   // accumulate connected component
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);    // sort emails in connected component
                component.add(0, emailToName.get(email));   // add name
                ans.add(component); // add to answers
            }
        }
        return ans;
    }
}
