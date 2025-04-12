void sort(char* s, int len){
    for(int i=1;i<len;i++){
        char curr = s[i];
        int prev = i-1;
        while(prev>=0 && s[prev]>curr){
            s[prev+1] = s[prev];
            prev--;
        }
        s[prev+1] = curr;
    }
}
int minimizedStringLength(char* s) {
    int len = strlen(s);
    sort(s,len);
    int count = 0;
    for(int i=0;i<len;i++){
        if(s[i]==s[i+1]){
            count++;
        }
    }
    return len-count;
}