class Solution {
    public StringBuilder add(StringBuilder num1, StringBuilder num2, int idx){
        StringBuilder ans = new StringBuilder("");
        int carry = 0;

        int i = idx;
        int j = 0;

        for(int x=0; x<i; x++){
            ans.append(num1.charAt(x));
        }

        while(i<num1.length() && j<num2.length()){
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(j) - '0';
            int sum = x+y;
            sum += carry;
            ans.append(sum%10);
            carry = sum/10;
            i++;
            j++;
        }
        while(i<num1.length()){
            int sum = (num1.charAt(i)-'0') + carry;
            ans.append(sum%10);
            carry = sum/10;
            i++;
        }
        while(j<num2.length()){
            int sum = (num2.charAt(j)-'0') + carry;
            ans.append(sum%10);
            carry = sum/10;
            j++;
        }

        if(carry != 0){
            ans.append(carry);
        }

        return ans.reverse();
    }
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder("");

        String n1;
        String n2;
        if(num1.length()<num2.length()){
            n1 = num1;
            n2 = num2;
        }
        else{
            n1 = num2;
            n2 = num1;
        }

        int i = n1.length()-1;
        int idx = 0;
        while(i>=0){
            StringBuilder s = new StringBuilder("");
            int carry = 0;
            int j = n2.length()-1;
            while(j>=0){
                int x = n1.charAt(i) - '0';
                int y = n2.charAt(j) - '0';
                int sum = x*y;
                sum += carry;
                s.append(sum%10);
                carry = sum/10;
                j--;
            }
            if(carry != 0) s.append(carry);

            ans = add(ans.reverse(), s, idx);

            i--;
            idx++;
        }

        int u = 0;
        for(int v=0; v<ans.length(); v++){
            if(ans.charAt(v)=='0'){
                u++;
            }
            else{
                break;
            }
        }
        if(u==ans.length()) return "0";
        return ans.substring(u).toString();
    }
}