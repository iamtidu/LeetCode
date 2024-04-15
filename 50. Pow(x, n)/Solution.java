class Solution {
    public double myPow(double x, int n) {
        // Base case: if n is 0, return 1
        if (n == 0) {
            return 1.0;
        }
        
        // Recursive case: calculate pow(x, n/2)
        double half = myPow(x, n / 2);
        
        // If n is even, return half * half
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd, return half * half * x (for positive n)
        else if (n > 0) {
            return half * half * x;
        }
        // If n is negative, return half * half / x (for negative n)
        else {
            return half * half / x;
        }
    }
}
