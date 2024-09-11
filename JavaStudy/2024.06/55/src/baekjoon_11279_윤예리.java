import java.util.PriorityQueue;
import java.util.Scanner;

public class baekjoon_11279_윤예리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();

            if (x==0) {
                if (!heap.isEmpty()) System.out.println(heap.poll() * -1);
                else System.out.println(0);
            }
            else {
                heap.offer(-1*x);
            }
        }
    }
}
