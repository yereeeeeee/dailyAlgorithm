import java.util.Arrays;

public class programmers_172927_윤예리 {
    static int[][] dp;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int dia = 0; int iron = 0; int stone = 0;
        // 곡괭이 수와 광물 다 캐는 숫자 중에 min 값을 cnt로 저장
        int cnt = Math.min(minerals.length/5 + 1, picks[0]+picks[1]+picks[2]);
        dp = new int[cnt][3];

        for (int i=0; i<minerals.length; i+=5) {
            if (i/5 == cnt) break;

            for (int j=i; j<i+5; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1;
                    iron += 5;
                    stone += 25;
                }
                else if(m.equals("iron")) {
                    dia += 1;
                    iron += 1;
                    stone += 5;
                }
                else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }

                if (j == minerals.length-1) break;
            }

            dp[i/5][0] = dia;
            dp[i/5][1] = iron;
            dp[i/5][2] = stone;

            dia = iron = stone = 0;
        }

        // 돌 피로도 높은 순 내림차순 정렬
        Arrays.sort(dp, (o1, o2) -> (o2[2] - o1[2]));
        // 다이아부터
        for (int i=0; i<cnt; i++) {
            if (picks[0] > 0) {
                answer += dp[i][0];
                picks[0] -= 1;
            }
            else if (picks[1] > 0) {
                answer += dp[i][1];
                picks[1] -= 1;
            }
            else if (picks[2] > 0) {
                answer += dp[i][2];
                picks[2] -= 1;
            }
        }

        return answer;
    }
}
