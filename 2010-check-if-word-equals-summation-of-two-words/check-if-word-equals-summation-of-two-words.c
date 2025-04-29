int NumericValue(char* s){
    int WordNum = 0;
    for(int i=0;s[i]!='\0';i++){
        int word = (int)s[i] - 97;
        WordNum = WordNum*10 + word;
    }
    return WordNum;
}
bool isSumEqual(char* firstWord, char* secondWord, char* targetWord) {
    if(NumericValue(firstWord) + NumericValue(secondWord) == NumericValue(targetWord)) return true;
    else return false;
}