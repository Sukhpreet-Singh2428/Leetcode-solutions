class Solution {
    public static int fact(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        return n*fact(n-1);
    }
    public boolean isDigitorialPermutation(int n) {
        int sum = 0;
        int temp = n;
        while(temp != 0){
            int d = temp%10;
            sum += fact(d);
            temp = temp/10;
        }

        StringBuilder s1 = new StringBuilder(String.valueOf(n));
        StringBuilder s2 = new StringBuilder(String.valueOf(sum));
        if(s1.length() != s2.length()) return false;
        char[] arr1 = s1.toString().toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toString().toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}