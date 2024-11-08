import java.io.*;
import java.util.*;

class Pos {
    int x, y, k;

    public Pos(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}

public class Main {
    static int n, m, k;
    static int[][] arr;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean isDay;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String tmp_line = br.readLine();
            String[] tmp_char = tmp_line.split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp_char[j]);
            }
        }
    }

    static void bfs() {
        PriorityQueue<Pos> q = new PriorityQueue<>();

    }
}