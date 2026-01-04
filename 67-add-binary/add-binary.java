class Solution {
    public static void reverse(char[] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void reverse(StringBuilder ans){
        int i = 0;
        int j = ans.length()-1;
        while(i<j){
            char temp = ans.charAt(i);
            ans.setCharAt(i, ans.charAt(j));
            ans.setCharAt(j, temp);
            i++;
            j--;
        }
    }
    public String addBinary(String a, String b) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        
        reverse(first);
        reverse(second);
        
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = 0;
        int j = 0;
        int n = first.length;
        int m = second.length;
        while(i<n || j<m){
            int sum = 0;
            if(i<n) sum += first[i] - '0';
            if(j<m) sum += second[j] - '0';
            sum += carry;

            if(sum == 2){
                ans.append(0);
                carry = 1;
            }
            else if(sum == 3){
                ans.append(1);
                carry = 1;
            }
            else{
                ans.append(sum);
                carry = 0;
            }
            
            if(i<n) i++;
            if(j<m) j++;
        }
        if(carry != 0){
            ans.append(carry);
        }
        
        reverse(ans);
        
        int x = 0;
        while(x<ans.length() && ans.charAt(x) == '0'){
            x++;
        }
        if(x>=ans.length()) return "0";
        return ans.substring(x);
    }
}