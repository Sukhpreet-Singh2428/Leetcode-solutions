int removePalindromeSub(char* s) {
    int i=0;
    int j=strlen(s)-1;
    while(i<=j){
        if(s[i]!=s[j]) return 2;
        i++;
        j--;
    }
    return 1;
}