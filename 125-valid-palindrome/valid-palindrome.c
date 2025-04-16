bool isPalindrome(char* s) {
    int len = strlen(s);
    for(int i=0;i<len;i++){
        if(s[i]>='A' && s[i]<='Z'){
            s[i] = tolower(s[i]);
        }
    }
    int j=0;
    for(int i=0;i<len;i++){
        if((s[i]>='a' && s[i]<='z') || (s[i]>='0' && s[i]<='9')){
            s[j++] = s[i];
        }
    }
    s[j] = '\0';
    int x = 0;
    int y = strlen(s)-1;
    while(x<=y){
        if(s[x]!=s[y]) return false;
        x++;
        y--;
    }
    return true;
}