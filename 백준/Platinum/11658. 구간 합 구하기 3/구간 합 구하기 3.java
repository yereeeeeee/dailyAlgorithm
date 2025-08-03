import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        tree = new int[4*n][4*n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildY(1, 0, n - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            // (x, y) -> c
            if (w == 0) {
                int c = Integer.parseInt(st.nextToken());
                updateY(1, 0, n - 1, x1 - 1, y1 - 1, c);
            }
            // (x1, y1) + (x2, y2)
            else {
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int result = queryY(1, 0, n - 1, x1 - 1, x2 - 1, y1 - 1, y2 - 1);
                System.out.println(result);
            }


        }

    }

    // segment tree 빌드
    static void buildY(int nodeX, int x1, int x2) {
        if (x1 == x2) {
            buildX(nodeX, 1, 0, n-1, x1);
        } else {
            int mid = (x1+x2) / 2;
            buildY(nodeX*2, x1, mid);
            buildY(nodeX*2+1, mid+1, x2);
            buildX(nodeX, 1, 0, n-1, -1);
        }
    }

    static void buildX(int nodeX, int nodeY, int y1, int y2, int row) {
        if (y1 == y2) {
            if (row != -1) {
                tree[nodeX][nodeY] = arr[row][y1];
            } else {
                tree[nodeX][nodeY] = tree[nodeX*2][nodeY] + tree[nodeX*2+1][nodeY];
            }
        } else {
            int mid = (y1 + y2) / 2;
            buildX(nodeX, nodeY*2, y1, mid, row);
            buildX(nodeX, nodeY*2+1, mid+1, y2, row);
            tree[nodeX][nodeY] = tree[nodeX][nodeY*2] + tree[nodeX][nodeY*2+1];
        }
    }

    // update
    static void updateY(int nodeX, int x1, int x2, int x, int y, int val) {
        if (x1 == x2) {
            updateX(nodeX, 1, 0, n - 1, x1, y, val);
        } else {
            int mid = (x1 + x2) / 2;
            if (x <= mid) updateY(nodeX * 2, x1, mid, x, y, val);
            else updateY(nodeX * 2 + 1, mid + 1, x2, x, y, val);
            updateX(nodeX, 1, 0, n - 1, -1, y, val);
        }
    }

    static void updateX(int nodeX, int nodeY, int y1, int y2, int row, int y, int val) {
        if (y1 == y2) {
            if (row != -1) {
                tree[nodeX][nodeY] = val;
                arr[row][y] = val;
            } else {
                tree[nodeX][nodeY] = tree[nodeX * 2][nodeY] + tree[nodeX * 2 + 1][nodeY];
            }
        } else {
            int mid = (y1 + y2) / 2;
            if (y <= mid) updateX(nodeX, nodeY * 2, y1, mid, row, y, val);
            else updateX(nodeX, nodeY * 2 + 1, mid + 1, y2, row, y, val);
            tree[nodeX][nodeY] = tree[nodeX][nodeY * 2] + tree[nodeX][nodeY * 2 + 1];
        }
    }

    // query
    static int queryY(int nodeX, int sx, int ex, int x1, int x2, int y1, int y2) {
        if (x2 < sx || ex < x1) return 0;
        if (x1 <= sx && ex <= x2) return queryX(nodeX, 1, 0, n - 1, y1, y2);
        int mid = (sx + ex) / 2;
        int left = queryY(nodeX * 2, sx, mid, x1, x2, y1, y2);
        int right = queryY(nodeX * 2 + 1, mid + 1, ex, x1, x2, y1, y2);
        return left + right;
    }

    static int queryX(int nodeX, int nodeY, int sy, int ey, int y1, int y2) {
        if (y2 < sy || ey < y1) return 0;
        if (y1 <= sy && ey <= y2) return tree[nodeX][nodeY];
        int mid = (sy + ey) / 2;
        int left = queryX(nodeX, nodeY * 2, sy, mid, y1, y2);
        int right = queryX(nodeX, nodeY * 2 + 1, mid + 1, ey, y1, y2);
        return left + right;
    }
}