class Solution {
    public int countDigit(int num){
        int len = 0;
        while(num != 0){
            len++;
            num = num/10;
        }
        return len;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int n = nums.length;
        int minSize = countDigit(low);
        int maxSize = countDigit(high);
        List<Integer> ls = new ArrayList<>();

        for(int size=minSize; size<=maxSize; size++){
            int l = 0;
            int r = 0;
            int num = 0;
            int len = 0;
            while(r < n){
                num = num*10 + nums[r];
                len++;

                if(len > size){
                    int temp = num;
                    int rev = 0;
                    while(temp != 0){
                        rev = rev*10 + temp%10;
                        temp = temp/10;
                    }
                    
                    rev = rev/10;
                    len--;
                    l++;

                    temp = 0;
                    while(rev != 0){
                        temp = temp*10 + rev%10;
                        rev = rev/10;
                    }

                    num = temp;
                }

                if(len==size){
                    if(num>=low && num<=high){
                        ls.add(num);
                    }
                }

                r++;
            }
        }

        return ls;
    }
}