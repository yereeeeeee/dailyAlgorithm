import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1405_윤예리 {
    static double[] percent = new double[4];
    static double result = 0;
    static boolean[][] visited = new boolean[30][30];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        dfs(15, 15, 0, n, 1);
        System.out.println(result);
    }

    static void dfs(int x, int y, int idx, int n, double value) {
        if (idx==n) {
            result += value;
            return;
        }

        visited[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 <= nx && nx < 30 && 0<= ny && ny < 30 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, idx+1, n, value * percent[d]);
                visited[nx][ny] = false;
            }
        }

    }
}
