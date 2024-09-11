import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr;
        for (int i=0; i<TC; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            int total = 0;

            for (int j=0; j<n; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[j] = value;
                total += value;
            }

            float avg = (total/n);
            int cnt = 0;

            for (int k=0; k<n; k++) {
                if (arr[k] > avg) {
                    cnt++;
                }
            }

            System.out.printf("%.3f%%\n",(cnt/n)*100);
        }
    }
}