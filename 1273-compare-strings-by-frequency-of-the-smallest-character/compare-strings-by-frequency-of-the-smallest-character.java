class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(String s : queries){
            int cnt = 0;
            HashMap<Character, Integer> mp = new HashMap<>();
            char mini = s.charAt(0);
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c < mini){
                    mini = c;
                }
                mp.put(c, mp.getOrDefault(c, 0)+1);
            }
            int freq = mp.get(mini);
            for(String x : words){
                HashMap<Character, Integer> mp1 = new HashMap<>();
                char mini1 = x.charAt(0);
                for(int i=0; i<x.length(); i++){
                    char c1 = x.charAt(i);
                    if(c1 < mini1){
                        mini1 = c1;
                    }
                    mp1.put(c1, mp1.getOrDefault(c1, 0)+1);
                }
                int freq1 = mp1.get(mini1);
                if(freq1 > freq){
                    cnt++;
                } 
            }
            ans.add(cnt);
        }

        int[] arr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
}