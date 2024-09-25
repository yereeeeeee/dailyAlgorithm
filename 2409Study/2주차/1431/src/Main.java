import javax.print.attribute.Size2DSyntax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int n;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    if (sum(o1) == sum(o2)) return o1.compareTo(o2);
                    else return sum(o1) - sum(o2);
                } else return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

    }

    static int sum(String a) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                result += a.charAt(i) - '0';
            }
        }
        return result;
    }
}