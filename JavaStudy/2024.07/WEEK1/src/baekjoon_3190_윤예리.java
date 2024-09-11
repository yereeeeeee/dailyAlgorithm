import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_3190_윤예리 {
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static HashMap<Integer, Character> dir = new HashMap<>();
    static Deque<int[]> snake = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // 0: 아무것도 없음, 1: 사과, 2: 뱀
        arr = new int[n][n];
        arr[0][0] = 2;

        // 사과
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x-1][y-1] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            dir.put(x, c);
        }

        snake.add(new int[]{0, 0});
        solution(0, 0, 1, 1);
    }

    static void solution(int x, int y, int d, int time) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (dir.containsKey(time)) {
            if (dir.get(time) == 'L') d = (d+3) % 4;
            else d = (d+1) % 4;
        }

        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            if (arr[nx][ny] == 1) {
                arr[nx][ny] = 2;
                snake.offerFirst(new int[]{nx, ny});
                solution(nx, ny, d, time+1);
            }

            else if (arr[nx][ny] == 2) {
                System.out.println(time);
                System.exit(0);
            }

            else {
                arr[nx][ny] = 2;
                snake.offerFirst(new int[]{nx, ny});
                int[] xy = snake.pollLast();
                int xx = xy[0];
                int yy = xy[1];

                arr[xx][yy] = 0;
                solution(nx, ny, d, time+1);
            }
        }

        else {
            System.out.println(time);
            System.exit(0);
        }
    }
}
