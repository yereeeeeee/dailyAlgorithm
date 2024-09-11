import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Float> scoreMap = new HashMap<>();
        scoreMap.put("A+", 4.5f); scoreMap.put("A0", 4.0f); scoreMap.put("B+", 3.5f);
        scoreMap.put("B0", 3.0f); scoreMap.put("C+", 2.5f); scoreMap.put("C0", 2.0f);
        scoreMap.put("D+", 1.5f); scoreMap.put("D0", 1.0f); scoreMap.put("F", 0.0f);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Float total = 0f;
        Float multi = 0f;

        for (int i=0; i<20; i++) {
            String s = br.readLine();
            String arr[] = s.split(" ");

            if (arr[2].equals("P")) {
                continue;
            } else {
                total += Float.parseFloat(arr[1]);
                multi += scoreMap.get(arr[2]) * Float.parseFloat(arr[1]);
            }


        }
        System.out.println(multi/total);
    }
}