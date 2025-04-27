char* removeDuplicates(char* s) {
    // int flag=1;      <-- Correct code, Correct logic !! but it pass 104/106 and gives TLC
    // while(flag){         bcz of efficieny o(n^2) !!
    //     int j=0;
    //     int check = strlen(s);
    //     for(int i=0;s[i]!='\0';i++){
    //         if(s[i]==s[i+1]) i++;
    //         else s[j++] = s[i];
    //     }
    //     s[j] = '\0';
    //     if(check==j) flag=0;
    // }
    // return s;
    
    int top = -1; // stack pointer
    for (int i = 0; s[i] != '\0'; ++i) {
        if (top >= 0 && s[top] == s[i]) {
            top--; // pop the stack (remove duplicate)
        } else {
            s[++top] = s[i]; // push onto the stack
        }
    }
    s[top + 1] = '\0'; // null-terminate
    return s;
}