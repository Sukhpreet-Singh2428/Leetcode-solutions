class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            mp.put(list1[i], i);
        }

        int mini = Integer.MAX_VALUE;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<list2.length; i++){
            if(mp.containsKey(list2[i])){
                int sum = i + mp.get(list2[i]);
                if(sum < mini){
                    mini = sum;
                    ans.clear();
                    ans.add(list2[i]);
                }
                else if(sum == mini){
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[0]);
        // String[] arr = new String[ans.size()];
        // for(int i=0; i<ans.size(); i++){
        //     arr[i] = ans.get(i);
        // }

        // return arr;
    }
}