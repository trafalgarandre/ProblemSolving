package Hackerrank;

import java.util.Scanner;

public class ConstructTheArray {

    static long countArray(int n, int _k, int x) {
        final long MODULO = 1000000007;
        long[] p = new long[n];
        long k = _k;
        int diff = (1 == x) ? 1 : 2;
        p[0] = (1 == x) ? 0 : 1;
        p[1] = k - diff;

        long q1 = k - 1;
        long q2 = ((k) * (k - 1)) % MODULO;
        for (int i = 2; i < n - 1; i++) {
            long temp = (q1 * 2 + MODULO - p[i - 2]) % MODULO;
            p[i] = (q2 + MODULO - temp) % MODULO;
            q1 = (q1 * (k - 1)) % MODULO;
            q2 = (q2 * (k - 1)) % MODULO;
        }
        return p[n - 2];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}
