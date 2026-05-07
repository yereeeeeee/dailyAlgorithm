import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int tan : tangerine) {
            numbers.put(tan, numbers.getOrDefault(tan, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(numbers.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int sum = 0;

        for (int count : counts) {
            sum += count;
            answer++;

            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}