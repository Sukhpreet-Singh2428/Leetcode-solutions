int getLucky(char* s, int k) {
    int sum = 0;
    for(int i=0;s[i]!='\0';i++){
        int n = s[i] - 'a' + 1;
        // while(n>0){
        //     sum += n%10;
        //     n = n/10;
        // }
        sum += n/10 + n%10;  //This is a shortcut to add the sum of digits of a 2-digit number (or 
    }                        // 1-digit) without using a loop
    for(int i=1;i<k;i++){
        int temp = sum;
        sum = 0;
        while(temp){
            sum += temp%10;
            temp = temp/10;
        }
    }
    return sum;
}