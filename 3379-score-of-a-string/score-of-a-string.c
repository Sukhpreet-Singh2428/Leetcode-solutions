int scoreOfString(char* s) {
    int sum = 0;
    for(int i=1;s[i]!='\0';i++){
        sum += abs(s[i-1] - s[i]);
    }
    return sum;
}