int maxNumberOfBalloons(char* text) {
   int freq[256] = {0};  // To store frequency of all characters
    for (int i = 0; text[i] != '\0'; i++) {
        freq[(int)text[i]]++;
    }
    int count_b = freq['b'];  //freq['b'] is just shorthand for freq[98]
    int count_a = freq['a'];
    int count_l = freq['l'] / 2;
    int count_o = freq['o'] / 2;
    int count_n = freq['n'];
    // The number of complete "balloon" words is the minimum of all these
    int min_count = count_b;
    if (count_a < min_count) min_count = count_a;
    if (count_l < min_count) min_count = count_l;
    if (count_o < min_count) min_count = count_o;
    if (count_n < min_count) min_count = count_n;
    return min_count;
}