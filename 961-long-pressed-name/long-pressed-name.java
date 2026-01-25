class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;

        int i=0;
        int j = 0;
        while(i<name.length()){
            char c = name.charAt(i);
            if(j<typed.length() && c != typed.charAt(j)) return false;
            int cntTyped = 0;
            while(j<typed.length() && c==typed.charAt(j)){
                cntTyped++;
                j++;
            }
            int cntName = 0;
            while(i<name.length() && c==name.charAt(i)){
                cntName++;
                i++;
            }
            if(cntTyped < cntName) return false;
        }
        
        return i==name.length() && j==typed.length();
    }
}