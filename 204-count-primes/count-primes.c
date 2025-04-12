int countPrimes(int n) {
    if (n < 2) return 0; // No primes less than 2
    
    bool isPrime[n]; 
    for (int i = 0; i < n; i++) isPrime[i] = true; // Assume all numbers are prime

    isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

    for (int i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false; // Mark multiples of i as non-prime
            }
        }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
        if (isPrime[i]) count++; // Count primes
    }

    return count;
}