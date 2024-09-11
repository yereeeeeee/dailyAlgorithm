import java.util.*;

class UserSolution {
    void init(int N, int mSoldier[][], char mMonarch[][][])
    {

    }
    void destroy()
    {

    }
    static HashMap<char[], char[]> Parent = new HashMap<>(); // x의 부모는 Parent.get(x)
    static HashMap<char[], LinkedList<char[]>> Enemy = new HashMap<>(); // x와 적대관계
    void union(char x[], char y[]) {
        x = find(x);
        y = find(y);

        if (x!=y) {
            Parent.put(x, y);
        }
    }
    char[] find(char x[]) {
        if (Parent.get(x) == x) {
            find(Parent.get(x));
        }
        return x;
    }
    int ally(char mMonarchA[], char mMonarchB[])
    {
        if (find(mMonarchA) == find(mMonarchB)) return -1; // 동맹관계라면
        if (Enemy.get(mMonarchA).contains(mMonarchB)) return -2; // 적대관계라면
        union(mMonarchA, mMonarchB);
        return 1;
    }
    static int[] dx = new int[]{-1, -1, -1, 0, 1, 1 ,1 ,0};
    static int[] dy = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
        // 적대관계가 된다.
        Enemy.get(mMonarchA).add(mMonarchB);
        Enemy.get(mMonarchB).add(mMonarchA);

        return -3;
    }
    int recruit(char mMonarch[], int mNum, int mOption) {
        if (mOption == 0) {
            for (int i = 0; i < mMonarch.length; i++) {

            }
        }
        return -1;
    }
}