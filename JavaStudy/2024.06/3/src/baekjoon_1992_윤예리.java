import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1992_윤예리 {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] =  str.charAt(j) - '0';
            }
        }
        QuadTree(0, 0, n);
        System.out.println(sb);
    }

    public static void QuadTree(int x, int y, int k) {
        if (check(x, y, k)) {
            sb.append(arr[x][y]);
            return;
        }

        int kk = k / 2;
        sb.append('(');

        QuadTree(x, y, kk);                // 왼쪽 위
        QuadTree(x, y+kk, kk);          // 오른쪽 위
        QuadTree(x+kk, y, kk);          // 왼쪽 아래
        QuadTree(x+kk, y+kk, kk);    // 오른쪽 아래

        sb.append(')');
    }

    public static boolean check(int x, int y, int k) {
        int point = arr[x][y];

        for (int i=x; i<x+k; i++) {
            for (int j=y; j<y+k; j++) {
                if (point != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
