/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(bruteForceGCD(60, 30));
        System.out.println(highSchoolGCD(60, 30));
        System.out.println(commonFactorGCD(64, 32));

        int nPrime = 100;
        int[] primeList = new int[nPrime];
        prime(nPrime, primeList);
        for (int a : primeList) {
            System.out.print(a != 0 ? a + " " : "");
        }
    }

    public static int bruteForceGCD(int m, int n) {
        int answer = 2;
        for (int x = 2; x <= Math.min(m, n); x++) {
            if (m % x == 0 && n % x == 0) {
                answer = x;
            }
        }
        return answer;
    }

    public static int highSchoolGCD(int m, int n) {
        int answer = 1;
        for (int i = 2; i <= Math.min(m, n); i++) {
            while (m % i == 0 && n % i == 0) {
                m /= i;
                n /= i;
                answer = answer * i;
            }
        }
        return answer;
    }

    public static int commonFactorGCD(int m, int n) {
        int answer = 1;
        // Find lists of factors of m and n
        int maxFactor = (int) (Math.log(m) / Math.log(2));
        int[] factors4m = new int[maxFactor + 1];
        factors(m, factors4m);

        maxFactor = (int) (Math.log(n) / Math.log(2));
        int[] factors4n = new int[maxFactor + 1];
        factors(n, factors4n);

        int pointM = 0, pointN = 0; // Pointer for running the factors
        while (factors4m[pointM] != -1 && factors4n[pointN] != -1 && pointM < factors4m.length
                && pointN < factors4n.length) {
            if (factors4m[pointM] == factors4n[pointN]) {
                answer = answer * factors4m[pointM];
                pointM++;
                pointN++;
            } else if (factors4m[pointM] < factors4n[pointN]) {
                pointM++;
            } else {
                pointN++;
            }
        }
        return answer;
    }

    public static void factors(int x, int[] factors) {
        int i = 0, factor = 2;
        while (factor <= x) {
            while (x % factor == 0) {
                x = x / factor;
                factors[i] = factor;
                i++;
            }
            factor++;
        }
        if (i < factors.length) {
            factors[i] = -1;
        }
    }

    public static void prime(int n, int[] l) {
        int[] A = new int[n + 1];
        A[0] = 0;
        A[1] = 0;
        for (int p = 0; p < A.length; p++) {
            A[p] = p;
        }
        // Get prime
        for (int p = 2; p < Math.floor(Math.sqrt(n)); p++) {
            int j = p * p; // The first number that p is a factor of
            while (j <= n) {
                A[j] = 0; // is a factor of p => 0 (not prime)
                j += p;
            }
        }
        for (int p = 2, i = 0; p <= n; p++) {
            if (A[p] != 0) {
                l[i] = A[p];
                i++;
            }
        }
    }
}