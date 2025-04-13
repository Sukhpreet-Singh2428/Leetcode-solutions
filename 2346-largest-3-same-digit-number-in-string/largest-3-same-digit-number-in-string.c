char* largestGoodInteger(char* num) {
    static char res[4] = "";
    res[0] = '\0'; 
    for (int i = 0; num[i + 2] != '\0'; i++) {
        if (num[i] == num[i + 1] && num[i] == num[i + 2]) {
            if (res[0] == '\0' || num[i] > res[0]) {
                res[0] = num[i];
                res[1] = num[i];
                res[2] = num[i];
                res[3] = '\0';
            }
        }
    }
    return res;
}

