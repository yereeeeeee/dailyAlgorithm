import java.util.*;
import java.io.*;

public class B2110 {

    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr[n-1] - arr[0] + 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (candi(mid) < c) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(end - 1);
    }

    static int candi(int dist) {
        int cnt = 1;
        int last = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int locate = arr[i];
            if (locate - last >= dist) {
                cnt++;
                last = locate;
            }
        }
        return cnt;
    }
}
