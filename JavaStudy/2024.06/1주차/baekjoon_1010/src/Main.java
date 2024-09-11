import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] dp = new int[30][30];
        for (int i=0; i<30; i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i=2; i<30; i++) {
            for (int j=1; j<30; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int T = sc.nextInt();

        for (int tc=0; tc<T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(dp[m][n]);
        }
    }

//    시간초과
//    public static int combi(int x, int y) {
//        if ( y==0 || x==y) return 1;
//        else return combi(x-1, y-1) + combi(x-1, y);
//    }
}