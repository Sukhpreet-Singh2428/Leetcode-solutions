bool isBalanced(char* num) {
    int even_sum = 0;
    int odd_sum = 0;
    int len = strlen(num);
    for(int i=0;i<len;i++){
        if(i%2==0){
            even_sum += num[i] - '0';  // (int)num[i] gives ASCII value but we need to convert char
        } else{                        // into int so we subtract '0' to convert char to int
            odd_sum += num[i] - '0';   // there num[i] - '0' works like if nums[i] = 5 so 
        }                              // ASCII value of 5 - ASCII value of 0 which gives int value
    }                                  // same as char !!
    if(even_sum == odd_sum) return true;
    else return false;
}