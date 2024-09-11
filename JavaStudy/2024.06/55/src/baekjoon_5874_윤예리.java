import java.util.Scanner;

public class baekjoon_5874_윤예리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split("");

            int cnt = 0;
            int sum = 0;
            for (int i=1; i<arr.length; i++) {
                if (arr[i].compareTo(arr[i-1]) == 0) { // 이전꺼랑 같으면
                    if (arr[i].compareTo("(") == 0) cnt++; // ( 이라면 cnt + 1
                    else sum += cnt; // ) 이라면 이전 ( 의 개수만큼 더해주기
                }
            }
            System.out.println(sum);
        }
    }
}
