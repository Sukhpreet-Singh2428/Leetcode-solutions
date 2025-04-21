int mySqrt(int x) {
    long long i = 0;
    while (i * i <= x) {
        i++;
    }
    return i - 1;
}
// Use long long for i to avoid overflow in i * i, especially when x is close to INT_MAX (2,147,483,647).