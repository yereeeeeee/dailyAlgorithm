import java.io.*;
import java.util.*;

public class B12763 {
    static int N, T, M;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        Arrays.fill(dist, 10001);
        dist[1] = 0;

        visited = new boolean[N+1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, time, cost));
            graph.get(v).add(new Node(u, time, cost));
        }
    }

    static void dijkstra() {

    }
}

class Node implements Comparable<Node>{
    int idx, time, cost;

    public Node(int idx, int time, int cost) {
        this.idx = idx;
        this.time = time;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // cost 기준 오름차순
        if (this.cost == o.cost) return this.time - o.time;
        return this.cost - o.cost;
    }
}
