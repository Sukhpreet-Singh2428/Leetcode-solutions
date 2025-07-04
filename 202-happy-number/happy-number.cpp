class Solution {
public:
    int f(int n){
    int sum = 0;
    while(n>0) {
        int digit = n%10;
        sum += digit*digit;
        n /= 10;
    }
    return sum;
    }
    int happyNum(int n, unordered_map<int,int>& mpp) {
    mpp[n]++;
    if(n==1) return 1;
    if(n!=1 && mpp[n]>1) return 0;
    return happyNum(f(n), mpp);
    }
    bool isHappy(int n) {
        unordered_map<int,int> mpp;
        int x = happyNum(n,mpp);
        return x==1;
    }
};