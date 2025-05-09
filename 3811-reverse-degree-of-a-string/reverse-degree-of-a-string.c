int reverseDegree(char* s) {
    int len = strlen(s);
    int n = 0;
    for(int i=1;i<=len;i++){
        int ch = 97 - (int)s[i-1] + 26;
        n = n + ch*i;
    }
    return n;
}