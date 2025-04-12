bool isPalindrome(int x) {
    if(x<0 || (x%10==0 && x!=0)){
        return false;
    }
    double original_x = x;
    double reverse_x = 0;
    while(x){
        reverse_x = reverse_x*10 + x%10;
        x = x/10;
    }
    if(original_x==reverse_x) return true;
    else return false;
}