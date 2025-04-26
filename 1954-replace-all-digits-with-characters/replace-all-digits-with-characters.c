char* replaceDigits(char* s) {
    for(int i=0;i<strlen(s);i++){
        if(s[i]>='0' && s[i]<='9'){
            int shift = s[i] - '0';
            char ch = s[i-1] + shift;
            s[i] = ch;
        }
    }
    return s;
}