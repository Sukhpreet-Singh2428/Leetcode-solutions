char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) return "";
    static char s[201];  // Buffer for result
    int i = 0;
    while (1){ //infinite loop, but it's not truly infinite because we have a break condition inside it
        char c = strs[0][i];   // Take character from first string
        if (c == '\0') break;
        for (int j = 1; j < strsSize; j++) {
            if (strs[j][i] != c) {
                s[i] = '\0';
                return s;
            }
        }
        s[i] = c;
        i++;
    }
    s[i] = '\0';
    return s;
}