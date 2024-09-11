import java.util.Scanner;

public class baekjoon_15652_윤예리 {
    static int[] result;

    public static void dfs(int idx, int n, int m, int val) {
        if (idx == m) {
            for (int x:result) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        for (int i=val; i<=n; i++) {
            result[idx] = i;
            dfs(idx + 1, n, m, i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        result = new int[m];
        dfs(0, n, m, 1);
    }
}
