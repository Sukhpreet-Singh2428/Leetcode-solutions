/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes) {
    int row = matrixSize;
    int col = matrixColSize[0];

    // Allocate memory for the transposed matrix
    int** result = (int**)malloc(col * sizeof(int*));
    *returnColumnSizes = (int*)malloc(col * sizeof(int));
    for (int i = 0; i < col; i++) {
        result[i] = (int*)malloc(row * sizeof(int));
        (*returnColumnSizes)[i] = row;
    }

    // Fill the transposed matrix
    for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
            result[i][j] = matrix[j][i];
        }
    }

    *returnSize = col;
    return result;
}