import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // 비용을 기준으로 오름차순 정렬
        return this.cost - o.cost;
    }
}

public class baekjoon_1238_윤예리 {
    static int n, m, x;
    static ArrayList<Node>[] graph, reGraph;
    static int[] dist, backDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        reGraph = new ArrayList[n+1];

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            reGraph[end].add(new Node(start, cost));
        }

    }

    static void solution() {

    }
}


//public static void main(String[] args) throws IOException {
//    br = new BufferedReader(new InputStreamReader(System.in));
//    bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    st = new StringTokenizer(br.readLine());
//    n = Integer.parseInt(st.nextToken());
//    m = Integer.parseInt(st.nextToken());
//    x = Integer.parseInt(st.nextToken());
//
//    adj = new ArrayList[n + 1];
//    r_adj = new ArrayList[n + 1];
//    dist = new int[n+1];
//    r_dist = new int[n+1];
//    Arrays.fill(dist, Integer.MAX_VALUE);
//    Arrays.fill(r_dist, Integer.MAX_VALUE);
//
//    for (int i = 0; i <= n; i++) {
//        adj[i] = new ArrayList<>();
//        r_adj[i] = new ArrayList<>();
//    }
//
//    for (int i = 0; i < m; i++) {
//        st = new StringTokenizer(br.readLine());
//        a = Integer.parseInt(st.nextToken());
//        b = Integer.parseInt(st.nextToken());
//        t = Integer.parseInt(st.nextToken());
//        adj[a].add(new Node(b, t));
//        r_adj[b].add(new Node(a, t));
//    }
//
//    // i~x 구하기
//    dijkstra(adj, dist, x);
//
//    // x~i 구하기
//    dijkstra(r_adj, r_dist, x);
//
//    // i~x + x~i 중 최댓값 구하기
//    int max = 0;
//    for(int i=1; i<=n; i++) {
//        max = Math.max(max, dist[i] + r_dist[i]);
//    }
//
//    System.out.println(max);
//
//}
//
//static void dijkstra(ArrayList<Node>[] arr, int[] dist, int start) {
//    PriorityQueue<Node> q = new PriorityQueue<Node>();
//    q.add(new Node(start, 0));
//    dist[start] = 0;
//
//    while(!q.isEmpty()) {
//        Node now = q.poll();
//        for(Node next : arr[now.node]) {
//            if (dist[next.node] > dist[now.node] + next.time) {
//                dist[next.node] = dist[now.node] + next.time;
//                q.add(new Node(next.node, dist[next.node]));
//            }
//        }
//    }
//}
