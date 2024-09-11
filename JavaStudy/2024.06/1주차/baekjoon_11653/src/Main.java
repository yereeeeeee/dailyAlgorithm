import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.exit(0);
        }

        while (n > 1) {
            for (int i=2; i<=n; i++) {
                if (n%i == 0) {
                    System.out.println(i);
                    n /= i;

                    if (n == 1) {
                        System.exit(0);
                    }

                    break;
                }
            }
        }
    }
}