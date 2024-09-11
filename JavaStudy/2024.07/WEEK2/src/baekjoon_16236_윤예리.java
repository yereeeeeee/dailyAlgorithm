import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baekjoon_16236_윤예리 {
    static int n;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Pos shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Pos(i, j);
                    arr[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int sharkSize = 2;
        int eatCnt = 0;

        while (true) {
            Queue<Pos> q = new LinkedList<>();

            int[][] visited = new int[n][n];

            q.offer(new Pos(shark.x, shark.y));

            int x = Integer.MAX_VALUE;
            int y = Integer.MAX_VALUE;
            int value = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                Pos cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] > sharkSize) continue; // 큰 물고기 못 머거 ㅠ
                    if (visited[nx][ny]!=0) continue;

                    visited[nx][ny] = visited[cur.x][cur.y] + 1; // 방문처리

                    if (arr[nx][ny] != 0 && arr[nx][ny] < sharkSize) {
                        if (value > visited[nx][ny]) { // 가장 가까운 물고기 먹기
                            value = visited[nx][ny];
                            x = nx;
                            y = ny;
                        }
                        else if (value == visited[nx][ny]) { // 거리가 같다?
                            if (nx == x) {
                                if (y > ny) { // 왼쪽 먹기
                                    x = nx; y = ny;
                                }
                            }
                            else if (nx < x) { // 위 먹기
                                x = nx; y = ny;
                            }
                        }
                    }

                    q.add(new Pos(nx, ny));

                }
            }

            if (x== Integer.MAX_VALUE && y == Integer.MAX_VALUE) break;

            answer += visited[x][y];
            arr[x][y] = 0;
            shark.x = x; shark.y = y;
            eatCnt += 1;

            if (eatCnt == sharkSize) {
                sharkSize += 1;
                eatCnt = 0;
            }
        }

        System.out.println(answer);

    }
}
