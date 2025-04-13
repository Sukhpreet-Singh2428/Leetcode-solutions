bool ispalindrome(char* word){
    int i = 0;
    int j = strlen(word) - 1;
    while(i<=j){
        if(word[i]!=word[j]){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
char* firstPalindrome(char** words, int wordsSize) {
    for(int i=0;i<wordsSize;i++){
        if(ispalindrome(words[i])){
            return words[i];
        }
    }
    return "";
}