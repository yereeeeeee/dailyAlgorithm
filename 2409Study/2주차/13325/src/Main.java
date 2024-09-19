import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, leaf;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        leaf = (int) Math.pow(2, k+1) - 1;
        weight = new int[leaf];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < leaf; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(weight));
    }
}