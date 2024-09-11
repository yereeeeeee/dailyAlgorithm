import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int point = 0;

        for (int i=0; i<10; i++) {
            int n = sc.nextInt();
            if (Math.abs(point-100) >= Math.abs(point-100+n)) {
                point += n;
            } else {
                break;
            }
        }

        System.out.println(point);
    }
}