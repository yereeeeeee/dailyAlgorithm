import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_18429_윤예리 {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(500, 0);
        System.out.println(answer);
    }

    static void solution(int value, int depth) {
        if (value<500) return;
        if (depth == n) {
            answer += 1;
            return;
        }

        value -= m;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(value + arr[i], depth+1);
                visited[i] = false;
            }
        }

    }
}
