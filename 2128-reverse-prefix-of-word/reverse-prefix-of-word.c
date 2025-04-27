char* reversePrefix(char* word, char ch) {
    int i=0;
    int j = -1;
    for (int k = 0; word[k] != '\0'; k++) {
        if (word[k] == ch) {
            j = k;
            break;
        }
    }
    if (j == -1) return word; // ch not found, return unchanged
    while(i<=j){
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
        i++;
        j--;
    }
    return word;
}