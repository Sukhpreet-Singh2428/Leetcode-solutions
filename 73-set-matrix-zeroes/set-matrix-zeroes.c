void setZeroes(int** matrix, int matrixSize, int* matrixColSize) {
    int m = matrixSize;
    int n = *matrixColSize;
    // Allocate space for row and column flags
    int* rowZero = (int*)calloc(m, sizeof(int));
    int* colZero = (int*)calloc(n, sizeof(int));
    // First pass: mark rows and columns to be zeroed
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                rowZero[i] = 1;
                colZero[j] = 1;
            }
        }
    }
    // Second pass: set matrix cells to zero if their row or column is marked
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (rowZero[i] || colZero[j]) {
                matrix[i][j] = 0;
            }
        }
    }
    // Free allocated memory
    free(rowZero);
    free(colZero);
}