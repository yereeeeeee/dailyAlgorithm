import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon_24511_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] typeArr = new int[n];
        for (int i=0; i<n; i++) {
            // 0: 큐, 1: 스택
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[m];
        for (int i=0; i<m; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<n; i++){
            if (typeArr[i] == 0) {
                dq.addFirst(arr[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<m; i++){
            dq.add(inputArr[i]);
            // remove 와 달리 poll은 없을 때 호출하면 에러 없이 null 반환
            result.append((dq.pollFirst() + " "));
        }

        System.out.println(result);
        br.close();
    }
}
