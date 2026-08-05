class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) return false;

        HashMap<Character, String> mp = new HashMap<>();
        HashMap<String, Character> pm = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            String str = arr[i];
            
            if(mp.containsKey(c)){
                if(!mp.get(c).equals(str)){
                    return false;
                }
            }
            if(pm.containsKey(str)){
                if(pm.get(str) != c){
                    return false;
                }
            }

            mp.put(c, str);
            pm.put(str, c);
        }

        return true;
    }
}