int secondHighest(char* s) {
    int max = -1;
    int smax = -1;
    int len = strlen(s);
    for(int i=0;i<len;i++){
        if(s[i]>='0' && s[i]<='9'){
            int digit = s[i] - '0';
            if(max<digit){
                smax = max;
                max = digit;
            } else if(smax<digit && digit!=max){
                smax = digit;
            }
        }
    }
    return smax;
}