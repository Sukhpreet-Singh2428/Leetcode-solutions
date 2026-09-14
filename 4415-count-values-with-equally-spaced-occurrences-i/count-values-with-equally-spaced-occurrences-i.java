class Pair{
    int freq;
    List<Integer> ls;

    public Pair(int freq, List<Integer> arr){
        this.freq = freq;
        ls = new ArrayList<>(arr);
    }
}
class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Pair> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            if(mp.containsKey(nums[i])){
                mp.get(nums[i]).freq = mp.get(nums[i]).freq + 1;
                mp.get(nums[i]).ls.add(i);
            }
            else{
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                mp.put(nums[i], new Pair(1, ls));
            }
        }

        int cnt = 0;
        for(int key : mp.keySet()){
            if(mp.get(key).freq == 3){
                HashSet<Integer> st = new HashSet<>();
                boolean found = true;
                for(int i=1; i<mp.get(key).ls.size(); i++){
                    int x = mp.get(key).ls.get(i) - mp.get(key).ls.get(i-1);
                    st.add(x);
                    if(st.size() > 1){
                        found = false;
                        break;
                    } 
                }
                if(found) cnt++;
            }
        }

        return cnt;
    }
}