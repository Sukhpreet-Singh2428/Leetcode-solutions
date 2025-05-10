bool isletter(char ch){
    if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z')) return true;
    return false;
}
char* reverseOnlyLetters(char* s) {
    int i = 0;
    int j = strlen(s)-1;
    while(i<=j){
       if(!isletter(s[i])) i++;
       else if(!isletter(s[j])) j--;
       else{
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
       }
    }
    return s;
}