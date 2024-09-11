import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_1021_윤예리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> dq = new LinkedList<Integer>();
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) {
            dq.add(i);
        }
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        // 1. 첫 번째 원소를 뽑는다.
        // 2. 왼쪽 또는 오른쪽으로 보낸다.
        // 3. 첫 번째 원소가 원하는 idx가 나올 때 까지 반복한다.
        // 가장 최소 cnt 만들기
        for (int i=0; i<m; i++) {
            int idx = Integer.parseInt(st.nextToken());

            // 첫 번째 원소를 뽑기
            while (dq.getFirst() != idx) {
                // 작은 수를 원하면
                // 첫 원소를 뒤로 보내준다.
                if (dq.indexOf(idx) <= (dq.size() / 2)) {
                    dq.addLast(dq.getFirst());
                    dq.removeFirst();
                } else {
                    // 큰 수를 원하면
                    // 반대로 옮겨준다.
                    dq.addFirst(dq.getLast());
                    dq.removeLast();
                }
                cnt += 1;
            }

            // 첫 원소가 원하는 수가 나왔다면 제거만 하고 끝
            if (dq.getFirst() == idx) {
                dq.removeFirst();
            }
        }
        System.out.println(cnt);
    }
}
