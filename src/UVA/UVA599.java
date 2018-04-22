package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The Forrest for the trees
public class UVA599 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int trees = 0;
            int acorns = 0;
            UnionFind union = new UnionFind(27);
            String current;
            while ((current = reader.readLine()).charAt(0) != '*') {
                int first = current.charAt(1) - 'A';
                int second = current.charAt(3) - 'A';
                union.unionSet(first, second);
            }
            current = reader.readLine();
            for (int j = 0; j < current.length(); j++) {
                if (j % 2 == 0) {
                    int cur = current.charAt(j) - 'A';
                    if (union.findSet(cur) == cur) {
                        if (union.getRank(cur) == 0) {
                            acorns++;
                        } else {
                            trees++;
                        }
                    }
                }
            }
            System.out.println("There are " + trees + " tree(s) and " + acorns + " acorn(s).");
        }
    }

    static class UnionFind {
        private int[] p, rank;

        public UnionFind(int n) {
            p = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }

        public int getRank(int i) {
            return rank[findSet(i)];
        }

        public int findSet(int i) {
            return (p[i] == i) ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int x = findSet(i), y = findSet(j);
                if (rank[x] > rank[y]) {
                    p[y] = x;
                } else {
                    p[x] = y;
                    if (rank[x] == rank[y]) {
                        rank[y]++;
                    }
                }
            }
        }
    }
}