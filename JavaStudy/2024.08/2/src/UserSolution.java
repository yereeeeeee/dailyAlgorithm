import java.util.*;

class UserSolution {
    static HashMap<Integer, PriorityQueue<Player>> bestMember = new HashMap<>();
    static HashMap<Integer, PriorityQueue<Player>> worstMember = new HashMap<>();
    static int leagueNum;

    void init(int N, int L, int mAbility[]) {
        leagueNum = N / L;
        for (int i = 0; i < leagueNum; i++) {
            // bestMember는 기본적으로 오름차순 (능력치가 큰 것이 위로 오도록)
            bestMember.put(i, new PriorityQueue<>(Collections.reverseOrder()));
            // worstMember는 내림차순 (능력치가 작은 것이 위로 오도록)
            worstMember.put(i, new PriorityQueue<>());
z
            for (int j = i * L; j < (i + 1) * L; j++) {
                bestMember.get(i).offer(new Player(j, mAbility[j]));
                worstMember.get(i).offer(new Player(j, mAbility[j]));
            }
        }
    }

    int move() {
        int sumId = 0;

        for (int i = 1; i < leagueNum - 1; i++) {
            Player bestPlayer = bestMember.get(i).poll();
            sumId += bestPlayer.id;
            Player worstPlayerTop = worstMember.get(i - 1).poll();
            sumId += worstPlayerTop.id;
            Player worstPlayer = worstMember.get(i).poll();
            sumId += worstPlayer.id;
            Player bestPlayerBot = bestMember.get(i + 1).poll();
            sumId += bestPlayerBot.id;

            // 하위리그 잘하는 사람 우리 리그에 넣기
            bestMember.get(i).offer(bestPlayerBot);
            worstMember.get(i).offer(bestPlayerBot);
            // 우리 리그 잘하는 사람 상위 리그에 넣기
            bestMember.get(i-1).offer(bestPlayer);
            worstMember.get(i-1).offer(bestPlayer);
            // 우리 리그 못하는 사람 하위 리그에 넣기
            bestMember.get(i+1).offer(worstPlayer);
            worstMember.get(i+1).offer(worstPlayer);

            // 상위 리그 못하는 사람 우리 리그에 넣기
            bestMember.get(i).offer(worstPlayerTop);
            worstMember.get(i).offer(worstPlayerTop);
        }
        return sumId;
    }

    int trade() {
        for (int i = 0; i < leagueNum; i++) {
            PriorityQueue<Player> tmp = bestMember.get(i);



        }
        return 0;
    }

    class Player implements Comparable<Player> {
        int id;
        int ability;

        public Player(int id, int ability) {
            this.id = id;
            this.ability = ability;
        }

        @Override
        public int compareTo(Player other) {
            return
                this.ability == other.ability ? Integer.compare(this.id, other.id):
                        Integer.compare(this.ability, other.ability);
        }
    }
}
