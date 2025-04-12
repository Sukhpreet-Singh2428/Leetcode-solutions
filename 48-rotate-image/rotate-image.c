void swap(int* i,int* j){
    int temp = *i;
    *i = *j;
    *j = temp;
    return;
}
void rotate(int** matrix, int matrixSize, int* matrixColSize) {
    for(int i=0;i<matrixSize;i++){
        for(int j=i;j<matrixSize;j++){
            swap(&matrix[i][j],&matrix[j][i]);
        }
    }
    for(int i=0;i<matrixSize;i++){
        int j=0;
        int k = matrixSize-1;
        while(j<k){
            swap(&matrix[i][j],&matrix[i][k]);
            j++;
            k--;
        }
    }
    return;
}