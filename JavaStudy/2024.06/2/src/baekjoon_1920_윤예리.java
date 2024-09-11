import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1920_윤예리 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int check = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(check, m));
        }
    }

    static int binarySearch(int key, int e){
        int start = 0;
        int end = e - 1 ;

        while (start <= end) {
            int mid = (start+end)/2;

            if (key == arr[mid]) return 1;
            else if (key<arr[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return 0;
    }

}
