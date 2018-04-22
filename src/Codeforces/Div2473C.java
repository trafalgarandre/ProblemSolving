package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div2473C {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 6) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println("1 " + (2 + i));
            }
            for (int i = 3; i < n - 1; i++) {
                System.out.println("2 " + (2 + i));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println((i + 1) + " " + (i + 2));
        }
    }
}
