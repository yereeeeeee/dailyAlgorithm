import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_2473_윤예리 {

    static int n;
    static int[] arr;

    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long tmp = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {

            int start = i+1;
            int end = n-1;

            while (start < end) {
                long curr = (long) arr[i] + arr[start] + arr[end];

                if (curr == 0) {
                    System.out.println(arr[i]+" "+arr[start]+" "+arr[end]);
                    return;
                }

                if (Math.abs(curr) < tmp) {
                    answer[0] = arr[i];
                    answer[1] = arr[start];
                    answer[2] = arr[end];
                    tmp = Math.abs(curr);
                }

                if (curr < 0) start++;
                else end--;
            }
        }

        System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
    }
}
