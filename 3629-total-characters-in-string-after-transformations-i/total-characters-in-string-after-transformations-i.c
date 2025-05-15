int lengthAfterTransformations(char* s, int t) {
    // int len = strlen(s);  // --> this gives TLC as we counting len and storing strings also !!
    // char* current = strdup(s);  // pointer allocation of string
    // for(int i=0;i<t;i++){
    //     char* next = (char*)malloc(2*len + 1);   // Worst case: every 'z' becomes "ab"
    //     int index = 0;
    //     for(int j=0;j<len;j++){
    //         if(current[j]!='z'){
    //             next[index++] = current[j] + 1;
    //         } else{
    //             next[index++] = 'a';
    //             next[index++] = 'b';
    //         }
    //     }
    //     next[index] = '\0';
    //     free(current);
    //     current = next;   // current pointer --> points to string next  (updated string)
    //     len = index;
    // }
    // int finalLength = strlen(current);
    // free(current);
    // return finalLength;

    // now just counting the length of string only 
    #define MOD 1000000007
    long long freq[26] = {0};
    for (int i = 0; s[i]; i++) {
        freq[s[i] - 'a']++;
    }
    while (t--) {
        long long next_freq[26] = {0};
        for (int i = 0; i < 25; i++) {
            next_freq[i + 1] = (next_freq[i + 1] + freq[i]) % MOD; // 'a' → 'b', ..., 'y' → 'z'
        }
        // Handle 'z' → "ab"
        next_freq[0] = (next_freq[0] + freq[25]) % MOD;  // 'z' → 'a'
        next_freq[1] = (next_freq[1] + freq[25]) % MOD;  // 'z' → 'b'
        for (int i = 0; i < 26; i++) {
            freq[i] = next_freq[i];
        }
    }
    // Total length = sum of all frequencies
    long long length = 0;
    for (int i = 0; i < 26; i++) {
        length = (length + freq[i]) % MOD;
    }
    return (int)length;
}