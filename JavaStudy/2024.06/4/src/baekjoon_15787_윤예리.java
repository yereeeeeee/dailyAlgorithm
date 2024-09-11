import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class baekjoon_15787_윤예리 {
    static int n, m;
    static int[] train;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        train = new int[n+1];

        int x;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            switch (c) {
                case 1:
                    x = Integer.parseInt(st.nextToken());
                    train[idx] |= (1<<x);
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    train[idx] &= ~(1<<x);
                    break;
                case 3:
                    train[idx] <<= 1;
                    train[idx] &= ((1<<21) -1);
                    break;
                case 4:
                    train[idx] >>= 1;
                    train[idx] &= ~1;
                    break;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i=1; i<=n; i++) {
            set.add(train[i]);
        }
        System.out.println(set.size());

    }
}
