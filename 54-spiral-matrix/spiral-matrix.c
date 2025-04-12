/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* spiralOrder(int** matrix, int matrixSize, int* matrixColSize, int* returnSize) {
    if (matrixSize == 0 || matrixColSize == NULL || *matrixColSize == 0) {
        *returnSize = 0;
        return NULL;
    }

    int minr = 0, maxr = matrixSize - 1;
    int minc = 0, maxc = (*matrixColSize) - 1;
    int tne = matrixSize * (*matrixColSize);
    int count = 0;

    // Allocate memory for the result
    int* result = (int*)malloc(tne * sizeof(int));
    *returnSize = tne;

    while (count < tne) {
        for (int j = minc; j <= maxc && count < tne; j++) {
            result[count++] = matrix[minr][j];
        }
        minr++; 
        for (int i = minr; i <= maxr && count < tne; i++) {
            result[count++] = matrix[i][maxc];
        }
        maxc--; 
        for (int j = maxc; j >= minc && count < tne; j--) {
            result[count++] = matrix[maxr][j];
        }
        maxr--; 
        for (int i = maxr; i >= minr && count < tne; i--) {
            result[count++] = matrix[i][minc];
        }
        minc++; 
    }
    return result;
}