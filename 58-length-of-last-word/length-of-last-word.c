int lengthOfLastWord(char* s) {
    int len = strlen(s);
    int i = len-1;
    while(i>=0 && s[i]==' '){   // remove space from last !!
        i--;
    }
    int wordlen = 0;
    while(i>=0 && s[i]!=' '){    // Count length of word from last !!
        wordlen++;
        i--;
    }
    return wordlen;
}