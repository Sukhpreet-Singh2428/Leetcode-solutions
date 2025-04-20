int myAtoi(char* s) {
    int k = 0;
    // 1. Ignore leading whitespaces
    while (s[k] == ' ') k++;
    // 2. Check if string is empty after trimming
    if (s[k] == '\0') return 0;
    // 3. Check for optional sign
    int checksign = 1;
    if (s[k] == '-') {
        checksign = -1;
        k++;
    } else if (s[k] == '+') {
        k++;
    }
    // 4. Parse digits and build the number
    long long num = 0;
    while (s[k] >= '0' && s[k] <= '9') {
        num = num * 10 + (s[k++] - '0');    // not use atoi() due to overflow condition 
        // 5. Handle overflow
        if (checksign * num > INT_MAX) return INT_MAX;
        if (checksign * num < INT_MIN) return INT_MIN;
    }
    return (int)(checksign * num);
}
