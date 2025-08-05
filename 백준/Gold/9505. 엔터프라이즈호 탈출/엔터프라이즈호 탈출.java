import java.io.*;
import java.util.*;

public class Main {
    static int T, k, w, h;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            HashMap<Character, Integer> enemyMap = new HashMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char name = st.nextToken().charAt(0);
                int cost = Integer.parseInt(st.nextToken());
                enemyMap.put(name, cost);
            }
            enemyMap.put('E', 0);

            board = new char[h][w];
            visited = new boolean[h][w];

            int startX = 0, startY = 0;
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char curChar = line.charAt(j);
                    if (curChar == 'E') {
                        startX = i;
                        startY = j;
                    }
                    board[i][j] = curChar;
                }
            }

            // 다익스트라
            PriorityQueue<Enemy> pq = new PriorityQueue<>();
            pq.add(new Enemy('E', 0, startX, startY, 0));

            while (!pq.isEmpty()) {
                Enemy curr = pq.poll(); // 최소 비용 노드 꺼내기

                int x = curr.x;
                int y = curr.y;

                if (visited[x][y]) continue; // 이미 확정된 노드면 스킵
                visited[x][y] = true;

                // 경계 도착 → 답 출력
                if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
                    System.out.println(curr.answer);
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (visited[nx][ny]) continue;

                    char newName = board[nx][ny];
                    int newCost = enemyMap.getOrDefault(newName, 0);

                    pq.add(new Enemy(newName, newCost, nx, ny, curr.answer + newCost));
                }
            }
        }
    }

    static class Enemy implements Comparable<Enemy> {
        char name;
        int cost;
        int x, y;
        int answer; // 누적 비용

        public Enemy(char name, int cost, int x, int y, int answer) {
            this.name = name;
            this.cost = cost;
            this.x = x;
            this.y = y;
            this.answer = answer;
        }

        @Override
        public int compareTo(Enemy o) {
            return this.answer - o.answer; // 누적 비용 기준 최소 힙
        }
    }
}
