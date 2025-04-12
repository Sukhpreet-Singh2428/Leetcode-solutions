/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** generateMatrix(int n, int* returnSize, int** returnColumnSizes) {
    // Allocate memory for the 2D array (matrix)
    int** matrix = (int**)malloc(n * sizeof(int*));
    // Allocate memory for column sizes array
    *returnColumnSizes = (int*)malloc(n * sizeof(int));
    // Initialize each row and set the column size
    for (int i = 0; i < n; i++) {
        matrix[i] = (int*)malloc(n * sizeof(int)); // Each row has 'n' columns
        (*returnColumnSizes)[i] = n; // Each row has exactly 'n' columns
    }
    // Set returnSize
    *returnSize = n;

    int minr=0,maxr=n-1;
    int minc=0,maxc=n-1;
    int count=0,tne=n*n;
    int value = 1;
    while(count<tne){
        // minimum row
        for(int j=minc;j<=maxc && count<tne;j++){
            matrix[minr][j] = value++;
            count++;
        }
        minr++;
        // maximum col
        for(int i=minr;i<=maxr && count<tne;i++){
            matrix[i][maxc] = value++;
            count++;
        }
        maxc--;
        // maximum row
        for(int j=maxc;j>=minc && count<tne;j--){
            matrix[maxr][j] = value++;
            count++;
        }
        maxr--;
        // minimum col
        for(int i=maxr;i>=minr && count<tne;i--){
            matrix[i][minc] = value++;
            count++;
        }
        minc++;
    }
    return matrix;
}