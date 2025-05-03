void capital(char* str, int start, int end){
    int len = end-start+1;
    if(len>2){
        str[start] = toupper(str[start]);
        start++;
    }
    for(int i=start;i<=end;i++){
        str[i] = tolower(str[i]);
    }
}
char* capitalizeTitle(char* title) {
    int start = 0;
    int n = strlen(title);
    for(int i=0;i<=n;i++){
        if(title[i]==' ' || title[i]=='\0'){
            capital(title,start,i-1);
            start = i+1;
        }
    }
    return title;
}