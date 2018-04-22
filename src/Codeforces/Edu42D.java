package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Edu42D {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        PriorityQueue<MyInteger> queue = new PriorityQueue<MyInteger>();
        long[] array = new long[n];

        for (int i = 0; i < n; i++) {
            queue.add(new MyInteger(Integer.parseInt(tokenizer.nextToken()), i));
            array[i] = -1;
        }
        int size = n;
        while (queue.size() != 0) {
            MyInteger first = queue.poll();
            if (queue.size() > 0 && queue.peek().value == first.value) {
                MyInteger stay = queue.poll();
                stay.multiply();
                queue.add(stay);
                size--;
            } else {
                array[first.position] = first.value;
            }
        }
        System.out.println(size);
        for (int i = 0; i < n; i++) {
            if (array[i] != -1) {
                System.out.print(array[i] + " ");
            }
        }
    }

    static class MyInteger implements Comparable<MyInteger>{
        public long value;
        public int position;

        MyInteger(long value, int position) {
            this.value = value;
            this.position = position;
        }

        public void multiply() {
            value *= 2;
        }

        public int compareTo(MyInteger other) {
            if (value == other.value) {
                return position - other.position;
            } else if (value < other.value){
                return -1;
            } else {
                return 1;
            }
        }
    }
}
