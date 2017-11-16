// https://leetcode.com/problems/employee-importance/description/

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    
    private int dfs(HashMap<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int cimp = e.importance;
        for (Integer s: e.subordinates)
            cimp += dfs(map, s);
        return cimp;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees)
            map.put(e.id, e);
        return dfs(map, id);
    }
}