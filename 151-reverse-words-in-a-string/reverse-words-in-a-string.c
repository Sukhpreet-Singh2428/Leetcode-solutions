void swap(char* s, int len){
    int x = 0;
    int y = len-1;
    while(x<=y){
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
        x++;
        y--;
    }
}
void word(char* s, int start, int end){
    for(int i=start,j=end;i<=j;i++,j--){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
char* reverseWords(char* s) {
    int len = strlen(s);
    swap(s,len);
    int start = 0;
    for(int i=0;i<=len;i++){
        if(s[i]==' ' || s[i]=='\0'){
            word(s,start,i-1);
            start = i + 1;
        }
    }
    //Remove extra spaces
    int i = 0, j = 0;
    bool space = true;
    while(s[i]) {
        if(s[i] != ' ') {
            if(j != 0 && space) s[j++] = ' ';   // insert single space before the word if needed
            s[j++] = s[i];                      // copy the character
            space = false;                      // we're inside a word
        } else { 
            space = true;                       // we saw a space, mark it
        }
        i++;
    }
    s[j] = '\0';
    return s;
}