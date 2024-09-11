import java.util.*;

public class test {
    static int minDifference = Integer.MAX_VALUE;
    static int N;
    static int[][] S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }

        }

        boolean[] team = new boolean[N];
        findMinDifference(team, 0, 0);
        System.out.println(minDifference);
    }

    // 백트래킹 을 써서 가능 모든 조합을 찾아주고 최소 차이를 계산
    static void findMinDifference(boolean[] team, int idx, int count) {
        if (count == N / 2) {
            caculateDifference(team);
            return;
        }

        if (idx >= N) return;

        team[idx] = true;
        findMinDifference(team, idx + 1, count + 1);

        team[idx] = false;
        findMinDifference(team, idx + 1, count);
    }

    // 차이값 계산해주는거
    static void caculateDifference(boolean[] team) {
        int startTeamscore = 0;
        int linkTeamscore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] == team[j]) {
                    startTeamscore += S[i][j] + S[j][i];
                } else if (!team[i] && !team[j]) {
                    linkTeamscore += S[i][j] + S[j][i];
                }
            }
        }
        int differnce = Math.abs(startTeamscore - linkTeamscore);
        minDifference = Math.min(minDifference, differnce);
    }
}