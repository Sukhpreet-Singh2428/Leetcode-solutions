int firstUniqChar(char* s) {
    int len = strlen(s);
    for(int i=0;i<len;i++){
        int flag = 1;
        for(int j=0;j<len;j++){
            if(i!=j && s[i]==s[j]){
                flag = 0;
                break;
            }
        }
        if(flag) return i;
    }
    return -1;
}