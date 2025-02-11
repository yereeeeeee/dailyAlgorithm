import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];
            }
        }



    }
}