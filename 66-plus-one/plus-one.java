class Solution {
    public static void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public int[] plusOne(int[] digits) {
        reverse(digits);

        int carry = 1;
        for(int i=0; i<digits.length; i++){
            if(carry == 0) break;
            int d = digits[i];
            d += carry;

            digits[i] = d%10;
            carry = d/10;
        }
        if(carry != 0){
            int[] ans = new int[digits.length+1];
            int j = 0;
            for(int i=0; i<digits.length; i++){
                ans[j] = digits[i];
                j++; 
            }
            ans[j] = carry;
            reverse(ans);
            return ans;
        }

        reverse(digits);

        return digits;
    }
}