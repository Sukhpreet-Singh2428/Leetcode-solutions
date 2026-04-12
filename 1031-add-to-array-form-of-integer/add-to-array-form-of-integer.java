class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ls = new ArrayList<>();

        int carry = 0;
        for(int i=num.length-1; i>=0; i--){
            int sum = num[i] + k%10;
            sum += carry;
            ls.add(sum%10);
            carry = sum/10;
            k = k/10;
        }
        while(k>0){
            int sum = k%10 + carry;
            ls.add(sum%10);
            carry = sum/10;
            k = k/10;
        }
        if(carry != 0) ls.add(carry);

        Collections.reverse(ls);

        return ls;
    }
}