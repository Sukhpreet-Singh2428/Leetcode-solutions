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
    int happyNum(int n, unordered_set<int>& st) {
    if(n==1) return 1;
    if(st.count(n)) return 0;
    st.insert(n);
    return happyNum(f(n), st);
    }
    bool isHappy(int n) {
        unordered_set<int> st;
        int x = happyNum(n,st);
        return x==1;
    }
};