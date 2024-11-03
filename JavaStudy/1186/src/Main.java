import java.io.*;
import java.util.*;

class Square {
    int number, size;

    public Square(int number, int size) {
        this.number = number;
        this.size = size;
    }
}

public class Main {
    static int N, K;
    static int[][] arr = new int[20001][20001];
    static int[] size;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20001; i++) {
            Arrays.fill(arr[i], -1);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        size = new int[N];
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 10000;
            int y1 = Integer.parseInt(st.nextToken()) + 10000;
            int x2 = Integer.parseInt(st.nextToken()) + 10000;
            int y2 = Integer.parseInt(st.nextToken()) + 10000;

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[j][k] = i;
                }
            }
        }

        for (int i = 0; i < 20001; i++) {
            for (int j = 0; j < 20001; j++) {
                if (arr[i][j] != -1) {
                    size[arr[i][j]] += 1;
                }
            }
        }

        PriorityQueue<Square> sizeList = new PriorityQueue<>((a, b) -> b.size - a.size);
        for (int i = 0; i < N; i++) {
            sizeList.add(new Square(i+1, size[i]));
        }

        int[] answer = new int[K];
        for (int i = 0; i < K; i++) {
            answer[i] = sizeList.poll().number;
        }
        Arrays.sort(answer);
        for (int i = 0; i < K; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}