package nz.ac.aucklanduni.rfen629.algorithm;

public class Algorithms {

    public static int gcdEuclidean(int n, int m) {
        if (n == m) return n;

        int a = Math.max(n, m);
        int b = Math.min(n, m);

        int remainder = a % b;
        return (remainder == 0) ? b : gcdEuclidean(b, remainder);
    }

    public static int sum(int a, int b) {
        int xor = a ^ b;
        int and = a & b;

        return (and == 0) ? xor : sum(and << 1, xor);
    }

}
