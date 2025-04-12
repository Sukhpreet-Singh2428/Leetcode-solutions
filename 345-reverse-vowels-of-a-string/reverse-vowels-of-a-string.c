bool isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
           ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
}
char* reverseVowels(char* s) {
    int i = 0;
    int j = strlen(s) - 1;    
    while(i < j) {
        while(i < j && !isVowel(s[i])) i++;
        while(i < j && !isVowel(s[j])) j--;
        if(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }  
    return s;
}