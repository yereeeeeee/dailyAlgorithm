import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_17413_윤예리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        boolean flag = false;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            
            // 태그가 열리면 이전에 tmp에 있던건 reverse해서 sb에 저장해주기
            if (c=='<') {
                sb.append(tmp.reverse());
                sb.append(c);
                tmp = new StringBuilder();
                flag = true;
            }
            // 태그가 닫히면 이전에 tmp에 있던건 그대로 sb에 저장해주기
            else if (c=='>') {
                sb.append(tmp).append(c);
                tmp = new StringBuilder();
                flag = false;
            }
            else if (c==' ') {
                if (flag) tmp.append(c); // flag가 true면 태그 안에 있는 단어니까 계속 tmp에 넣어주기
                else { // 아니라면 뒤집어서 넣어주기
                    sb.append(tmp.reverse().append(c));
                    tmp = new StringBuilder();
                }
            }
            else tmp.append(c); // 글자가 들어오면 tmp에 append
        }

        // tmp에 남아있으면 추가로 더해주기
        if (!tmp.equals("")) sb.append(tmp.reverse());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
