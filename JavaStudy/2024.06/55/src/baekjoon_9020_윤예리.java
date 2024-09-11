import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_9020_윤예리 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int a = n/2;
            int b = n-a;

            while (true) {
                if (check(a) && check(b)) {
                    System.out.println(a+" "+b);
                    break;
                }
                else {
                    a -= 1;
                    b += 1;
                }
            }
        }
    }

    static boolean check(int x) {
        isPrime = new boolean[x+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = true;

        for (int i=2; i<=Math.sqrt(x); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= x; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime[x];
    }
}
