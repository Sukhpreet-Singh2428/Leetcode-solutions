/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int total;
    public void dfs(Employee employee, HashMap<Integer, Employee> mp){
        total += employee.importance;

        for(int x : employee.subordinates){
            dfs(mp.get(x), mp);
        }
    }
    public int getImportance(List<Employee> employees, int id) {
        Employee start = employees.get(0);
        
        HashMap<Integer, Employee> mp = new HashMap<>();
        for(int i=0; i<employees.size(); i++){
            if(id == employees.get(i).id){
                start = employees.get(i);
            }
            mp.put(employees.get(i).id, employees.get(i));
        }

        total = 0;
        dfs(start, mp);

        return total;
    }
}