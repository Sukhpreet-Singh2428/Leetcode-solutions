// Merge function for Merge Sort
void merge(char* arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    char leftArr[n1], rightArr[n2];
    for (int i = 0; i < n1; i++)
        leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        rightArr[j] = arr[mid + 1 + j];
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        arr[k] = leftArr[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = rightArr[j];
        j++;
        k++;
    }
}
// Merge Sort function
void mergeSort(char* arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);    // Sort the left half
        mergeSort(arr, mid + 1, right);  // Sort the right half
        merge(arr, left, mid, right);  // Merge the sorted halves
    }
}
bool isAnagram(char* s, char* t) {
    int len1 = strlen(s);
    int len2 = strlen(t);
    if(len1!=len2) return false;
    // Sort both strings
    mergeSort(s, 0, len1 - 1);
    mergeSort(t, 0, len2 - 1);
    if(strcmp(s,t)==0) return true;
    else return false;
}