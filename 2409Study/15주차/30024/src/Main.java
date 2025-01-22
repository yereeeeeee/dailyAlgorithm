import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        k = Integer.parseInt(st.nextToken());

        // 옥수수 밭 돌면서 q에 넣고 힙으로 뽑기
    }

    static class Pos {
        int x; int y; int value;
        public Pos(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}