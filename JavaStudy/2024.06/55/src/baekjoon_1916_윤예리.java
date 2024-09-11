import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1916_윤예리 {
    static class Node {
        int v, cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n+1];
        visited = new boolean[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        solution(u);
        System.out.println(dist[v]);
    }

    static void solution(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Node next : graph.get(now.v)) {
                    if (dist[next.v] > dist[now.v] + next.cost) {
                        dist[next.v] = dist[now.v] + next.cost;
                        q.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }
}
