import java.io.*;
import java.util.*;

public class baekjoon_7453_윤예리 {
    static int n;
    static int[] arr, brr, crr, drr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n]; brr = new int[n]; crr = new int[n]; drr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
            crr[i] = Integer.parseInt(st.nextToken());
            drr[i] = Integer.parseInt(st.nextToken());

        }
    }
}
