import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public interface baekjoon_2470_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = (n-1);

        int left_answer = arr[start];
        int right_answer = arr[end];
        int tmp = Integer.MAX_VALUE;

        while (start < end) {

            int target = arr[start] + arr[end]; // 현재 계산하는 값

            if (target == 0) {
                System.out.println(arr[start]+" "+arr[end]);
                return;
            }

            if (tmp > Math.abs(target)) {
                tmp = Math.abs(target);
                left_answer = arr[start];
                right_answer = arr[end];
            }

            if (target < 0) start += 1;
            else end -= 1;
        }
        System.out.println(left_answer+" "+right_answer);
    }
}
