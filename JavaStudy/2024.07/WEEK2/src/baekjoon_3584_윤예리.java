import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_3584_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n+1];

            for (int j = 0; j < n - 1; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> par_x = new ArrayList<>();
            par_x.add(0); par_x.add(x);

            List<Integer> par_y = new ArrayList<>();
            par_y.add(0); par_y.add(y);

            while (parent[x] != 0) {
                par_x.add(parent[x]);
                x = parent[x];
            }

            while (parent[y] != 0) {
                par_y.add(parent[y]);
                y = parent[y];
            }

            par_x.reversed(); par_y.reversed();
            for (int j = 0; j < n; j++) {

            }
        }
    }
}
