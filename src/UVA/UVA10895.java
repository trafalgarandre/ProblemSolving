package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA10895 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        String temp;
        while ((temp = reader.readLine()) != null) {
            tokenizer = new StringTokenizer(temp);
            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int count = 0;
            ArrayList<ArrayList<Element>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(new ArrayList<Element>());
            }

            while (count < m) {
                tokenizer = new StringTokenizer(reader.readLine());
                int num_pos = Integer.parseInt(tokenizer.nextToken());
                if (num_pos == 0) {
                    count++;
                    reader.readLine();
                    continue;
                }
                Queue<Integer> pos = new LinkedList<>();
                for (int i = 0; i < num_pos; i++) {
                    pos.add(Integer.parseInt(tokenizer.nextToken()) - 1);
                }
                tokenizer = new StringTokenizer(reader.readLine());
                for (int i = 0; i < num_pos; i++) {
                    arr.get(pos.poll()).add(new Element(count + 1, Integer.parseInt(tokenizer.nextToken())));
                }
                count++;
            }

            System.out.println(n + " " + m);
            for (int i = 0; i < n; i++) {
                ArrayList<Element> cur_row = arr.get(i);
                int non_zero = cur_row.size();
                System.out.print(non_zero);
                for (int j = 0; j < non_zero; j++) {
                    System.out.print(" " + cur_row.get(j).pos);
                }
                System.out.println();
                if (cur_row.size() != 0) {
                    System.out.print(cur_row.get(0).val);
                }
                for (int j = 1; j < non_zero; j++) {
                    System.out.print(" " + cur_row.get(j).val);
                }
                System.out.println();
            }
        }
    }

    static class Element {
        int pos;
        int val;
        Element(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }
}
