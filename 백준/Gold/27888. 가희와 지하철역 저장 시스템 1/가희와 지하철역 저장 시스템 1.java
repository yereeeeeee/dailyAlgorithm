import java.io.*;
import java.util.*;

public class Main {
    // 특징 이름 → 비트 위치
    static HashMap<String, Integer> sp = new HashMap<>();
    // 특징 비트마스크 → 해당 특징 조합 가진 역 수
    static HashMap<Integer, Integer> db = new HashMap<>();
    // 역 이름 → 특징 비트마스크
    static HashMap<String, Integer> st = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int b = 0;  // 새로운 특징에 부여할 비트 인덱스
        int n = Integer.parseInt(br.readLine());
        
        // 초기 역 이름 입력, 특징은 0 (없음)
        for (int i = 0; i < n; i++) {
            String stationName = br.readLine().trim();
            st.put(stationName, 0);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().trim().split(" ");
            String command = parts[0];
            
            if (command.equals("U")) {
                String stationName = parts[1];
                String[] features = parts[2].split(",");
                
                // 기존 특징 비트마스크
                int oldMask = st.getOrDefault(stationName, 0);
                
                // 기존 특징 조합 역 수 1 감소 (있으면)
                if (db.containsKey(oldMask)) {
                    int count = db.get(oldMask);
                    if (count == 1) db.remove(oldMask);
                    else db.put(oldMask, count - 1);
                }
                
                // 새로운 특징 비트마스크 생성
                int newMask = 0;
                for (String f : features) {
                    if (!sp.containsKey(f)) {
                        sp.put(f, b++);
                    }
                    int bitPos = sp.get(f);
                    newMask |= (1 << bitPos);
                }
                
                // 역 특징 업데이트
                st.put(stationName, newMask);
                
                // 새로운 특징 조합 역 수 1 증가
                db.put(newMask, db.getOrDefault(newMask, 0) + 1);
                
            } else if (command.equals("G")) {
                String[] features = parts[1].split(",");
                int queryMask = 0;
                boolean valid = true;
                
                for (String f : features) {
                    if (!sp.containsKey(f)) {
                        // 특징이 하나라도 없으면 답은 0
                        System.out.println(0);
                        valid = false;
                        break;
                    }
                    int bitPos = sp.get(f);
                    queryMask |= (1 << bitPos);
                }
                
                if (!valid) continue;
                
                int ans = 0;
                // db의 모든 특징 조합 중 queryMask를 포함하는 조합 개수 더하기
                for (Map.Entry<Integer, Integer> entry : db.entrySet()) {
                    int mask = entry.getKey();
                    if ((mask & queryMask) == queryMask) {
                        ans += entry.getValue();
                    }
                }
                
                System.out.println(ans);
            }
        }
    }
}
