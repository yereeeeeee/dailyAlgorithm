import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) break;
            
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = sign(Integer.parseInt(st.nextToken()));
            }

            tree = new int[4 * n];
            build(arr, 1, 0, n - 1);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);

                if (cmd == 'C') { // Change
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    int val = sign(Integer.parseInt(st.nextToken()));
                    update(1, 0, n - 1, idx, val);
                } else if (cmd == 'P') { // Product sign query
                    int l = Integer.parseInt(st.nextToken()) - 1;
                    int r = Integer.parseInt(st.nextToken()) - 1;
                    int res = query(1, 0, n - 1, l, r);
                    if (res == 0) sb.append('0');
                    else if (res > 0) sb.append('+');
                    else sb.append('-');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static int sign(int x) {
        if (x > 0) return 1;
        if (x < 0) return -1;
        return 0;
    }

    static void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, node * 2, start, mid);
            build(arr, node * 2 + 1, mid + 1, end);
            tree[node] = tree[node * 2] * tree[node * 2 + 1];
        }
    }

    static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) update(node * 2, start, mid, idx, val);
            else update(node * 2 + 1, mid + 1, end, idx, val);
            tree[node] = tree[node * 2] * tree[node * 2 + 1];
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 1; // 곱셈 항등원
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        int leftRes = query(node * 2, start, mid, l, r);
        int rightRes = query(node * 2 + 1, mid + 1, end, l, r);
        return leftRes * rightRes;
    }
}
