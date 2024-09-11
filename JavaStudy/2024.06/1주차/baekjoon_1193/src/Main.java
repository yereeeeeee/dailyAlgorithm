import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 홀수번째 대각선: 분자 감소, 분모 증가
        // 짝수번째 대각선: 분자 증가, 분모 감소

        // k 번째 라인은 k 개의 분수를 가짐
        int line = 0;
        int k = 0;
        while (n > k) {
            line += 1;
            k += line;
        }

        int denom, numer;
        if (line%2 == 0) { // 짝수 라인
            denom = line - k + n;
            numer = k - n + 1;
        } else {
            denom = k - n + 1;
            numer = line - k + n;
        }

        String s_denom = Integer.toString(denom);
        String s_numer = Integer.toString(numer);
        System.out.println(s_denom+"/"+s_numer);

    }
}