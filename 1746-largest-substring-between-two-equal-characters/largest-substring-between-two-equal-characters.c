int maxLengthBetweenEqualCharacters(char* s) {
    int x = 0;
    int n = strlen(s);
    int count = -1;
    for(int i=0;i<n;i++){
        for(int j=n-1;j>i;j--){
            if(s[i]==s[j]){
                x = j-i-1;
                if(x>count){
                    count = x;
                }
            }
        }
    }
    return count;
}
// while(i<=j){                       logic is correct but only compares characters from the start and 
//         if(s[i]==s[j]){            end of the string moving towards the center, which will miss 
//             int gap = j-i-1;       many possible pairs. so we have to operate all the cases so use 
//             if(gap>count) count = gap;  double loop.
//         }
//         i++;
//         j--;
//     }