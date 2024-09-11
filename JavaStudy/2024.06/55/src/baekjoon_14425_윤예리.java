import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14425_윤예리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;
        for (int i=0; i<m; i++) {
            String x = br.readLine();
            for (int j=0; j<n; j++) {
                if (arr[j].equals(x)) {
                    answer += 1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
