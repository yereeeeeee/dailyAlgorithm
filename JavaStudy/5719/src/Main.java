import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int idx, cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int N, M;
    static int S, D;
    static int[] dist;
    static boolean[][] visited;
    static List<Node>[] graph;
    static List<Integer>[] removeList;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) return;

            dist = new int[N];
            visited = new boolean[N][N];
            graph = new ArrayList[N];
            removeList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                removeList[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[v].add(new Node(w, cost));
            }

            dijkstra(S);
            remove(S, D);
            Arrays.fill(dist, INF);
            dijkstra(S);

            System.out.println(dist[D] == INF ? -1 : dist[D]);
        }
    }

    static void dijkstra(int s) {
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.cost > dist[now.idx]) continue;

            for (Node nxt: graph[now.idx]) {
                if (visited[now.idx][nxt.idx]) continue;

                if (dist[nxt.idx] > dist[now.idx] + nxt.cost) {
                    dist[nxt.idx] = dist[now.idx] + nxt.cost;
                    q.offer(new Node(nxt.idx, dist[nxt.idx]));

                    removeList[nxt.idx].clear();
                    removeList[nxt.idx].add(now.idx);
                }
                else if (dist[nxt.idx] == dist[now.idx] + nxt.cost) {
                    removeList[nxt.idx].add(now.idx);
                }
            }
        }
    }

    static void remove(int s, int d) {
        if (s == d) return;
        for (int prev : removeList[d]) {
            if (!visited[prev][d]) {
                visited[prev][d] = true;
                remove(s, prev);
            }
        }
    }
}
