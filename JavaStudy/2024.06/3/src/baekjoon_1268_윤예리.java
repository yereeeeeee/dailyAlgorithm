import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1268_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] tmp = new boolean[n][n];

        int[][] arr = new int[n][5];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j=0; j<5; j++) {
            ArrayList<Integer>[] check = new ArrayList[10];
            for (int i=0; i<n; i++) {
                if (check[arr[i][j]] == null){
                    check[arr[i][j]] = new ArrayList<>();
                    check[arr[i][j]].add(i);
                }
            }

            for (int i=0; i<n; i++){
                int num = arr[i][j];

                ArrayList<Integer> lst = check[num];
                for (int k=0; k<lst.size(); k++){
                    if (i == lst.get(k)) continue;
                    tmp[i][lst.get(k)] = true;
                }
            }

        }

        int max_cnt = 0;
        int idx = 0;
        for (int i=0; i<n; i++) {
            int nb = 0;
            for (int j=0; j<n; j++) {
                if (tmp[i][j]) {
                    nb ++;
                }
            }
            if (max_cnt < nb){
                max_cnt = nb;
                idx = i;
            }
        }
        System.out.println(idx+1);
    }
}
