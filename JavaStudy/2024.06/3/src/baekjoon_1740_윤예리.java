import java.util.Scanner;

public class baekjoon_1740_윤예리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = Long.parseLong(sc.next());
        long value = 1;
        long answer = 0;

        while (n>0){
            if ((n&1)==1) {
                answer += value;
            }

            value *= 3;
            n = n>>1;
        }
        System.out.println(answer);
    }
}
