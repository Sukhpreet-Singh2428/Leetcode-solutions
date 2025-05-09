void reverse(char* str, int i, int j){
    while(i<=j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        i++;
        j--;
    }
}
char* reverseStr(char* s, int k) {
    int len = strlen(s);
    for(int start=0;start<len; start += 2*k){
        int end = (start+k-1<len) ? (start+k-1) : (len-1);
        reverse(s,start,end);
    }
    return s;
}