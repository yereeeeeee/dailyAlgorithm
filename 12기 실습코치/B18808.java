import java.io.*;
import java.util.*;

public class B18808 {
    static int n, m, k;
    static int[][] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        base = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            attachSticker(sticker);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (base[i][j] == 1) answer++;
            }
        }
        System.out.println(answer);
    }

    static void attachSticker(int[][] sticker) {
        for (int rot = 0; rot < 4; rot++) {
            int r = sticker.length, c = sticker[0].length;

            for (int i = 0; i <= n - r; i++) {
                for (int j = 0; j <= m - c; j++) {
                    if (canAttach(i, j, sticker)) {
                        applySticker(i, j, sticker);
                        return;
                    }
                }
            }

            // 회전 후 크기 업데이트
            sticker = rotate(sticker);
        }
    }

    static boolean canAttach(int x, int y, int[][] sticker) {
        int r = sticker.length, c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1 && base[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void applySticker(int x, int y, int[][] sticker) {
        int r = sticker.length, c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) {
                    base[x + i][y + j] = 1;
                }
            }
        }
    }

    static int[][] rotate(int[][] sticker) {
        int r = sticker.length, c = sticker[0].length;
        int[][] rotated = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotated[j][r - 1 - i] = sticker[i][j];
            }
        }
        return rotated;
    }
}
