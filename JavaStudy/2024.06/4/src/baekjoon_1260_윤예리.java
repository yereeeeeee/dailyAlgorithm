import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1260_윤예리 {
    static int n, m, v;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] nodes;
    static Boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n+1];
        visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        // 2중 배열
        for (int i=0; i<n+1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }
        // 정렬
        for (int i=0; i<n+1; i++) {
            Collections.sort(nodes[i]);
        }
        dfs(v);
        visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx+" ");

        for (int node: nodes[idx]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int nxt = q.poll();
            sb.append(nxt + " ");

            for (int node:nodes[nxt]) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }

    }
}
