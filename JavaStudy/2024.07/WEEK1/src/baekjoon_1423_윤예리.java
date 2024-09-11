import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1423_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] level = new long[n+1];
        level[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            level[i] = Long.parseLong(st.nextToken());
        }

        long[] power = new long[n+1];
        power[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            power[i] = Long.parseLong(st.nextToken());
        }

        int d = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 1; i < n+1; i++) {
            result += level[i] * power[i];
            level[i] = Math.min(d, level[i]); // 상한선 정하기
            // 만약 계속 높아진다면, 어디까지 높아질 수 있는가?
            // 얘 바로 아래 N명이 다 레벨업을 한다고 치면 최대 N명이 추가될 수 있음
            // 그니까 이제 N명보다 많은 인원은 고려할 필요가 없는거지
            // 괜히 시간만 잡아먹으니까
        }

        long[] dp = new long[d+1];
        // Arrays.fill(dp, 0);
        for (int i = 1; i < n+1; i++) {
            while (level[i] > 0) {
                level[i] -= 1; // 한 명 골라서

                for (int j = d; j >= 0; j--) {
                    for (int k = i+1; k < n+1; k++) { // 레벨을 높일지 말지 이후 레벨들을 순회하면서 확인
                        if (k+j-i <= d) dp[k+j-i] = Math.max(dp[k+j-i], dp[j] + (power[k] - power[i]));
                    }
                }
            }

        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[d] + result);
    }
}
