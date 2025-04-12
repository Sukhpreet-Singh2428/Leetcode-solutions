char* removeStars(char* s) {
    int j = 0;
    int len = strlen(s);
    for(int i=0;i<len;i++){
        if(s[i]=='*'){
            if(j>0) j--;    // Remove the previous character
        } else{
            s[j++] = s[i];   // Add current character
        }
    }
    s[j] = '\0';
    return s;
}