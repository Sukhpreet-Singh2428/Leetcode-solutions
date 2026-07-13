class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            mp1.put(c, mp1.getOrDefault(c, 0)+1);
        }

        int n = s2.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> mp2 = new HashMap<>();

        while(r < n){
            char c = s2.charAt(r);

            if(!mp1.containsKey(c)){
                mp2.clear();
                l = r+1;
            }
            else{
                mp2.put(c, mp2.getOrDefault(c, 0)+1);
                
                while(mp2.get(c) > mp1.get(c)){
                    mp2.put(s2.charAt(l), mp2.get(s2.charAt(l))-1);

                    if(mp2.get(s2.charAt(l)) == 0){
                        mp2.remove(s2.charAt(l));
                    }

                    l++;
                }

                if(r-l+1 == s1.length()){
                    return true;
                }
            }

            r++;
        }

        return false;
    }
}