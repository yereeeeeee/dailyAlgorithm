import java.io.*;
import java.util.*;

public class Main {
    static int t, n, k;
    static List<List<Integer>> parent;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            times = new int[n+1];
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                times[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }
        }
    }

    static void union(int x, int y) {
        if (parent[x] == parent[y]) return;

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}