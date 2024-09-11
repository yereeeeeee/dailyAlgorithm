import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon_14889_윤예리 {
    static int n;
    static int[][] arr;
    static int min_v = 30000;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0);
        System.out.println(min_v);
    }

    static void combination(int idx, int depth) {
        if (depth == n/2) {
            solution();
            return;
        }

        for (int i=idx; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void solution() {
        int start = 0;
        int link = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int value = Math.abs(start-link);
        if (value == 0) {
            System.out.println(value);
            System.exit(0);
        }

        min_v = Math.min(value, min_v);
    }
}
