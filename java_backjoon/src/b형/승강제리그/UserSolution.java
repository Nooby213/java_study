package b형.승강제리그;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class UserSolution {
    static int N;
    static int L;
    static List<League> leagues;

    void init(int N, int L, int mAbility[]) {
        this.N = N;
        this.L = L;
        int idx = 0;
        int players = N / L;
        leagues = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            leagues.add(new League());
        }
        for (int i = 0; i < L; i++) {
            List<Player> temp = new ArrayList<>();
            for (int j = 0; j < players; j++) {
                temp.add(new Player(idx, mAbility[idx]));
                idx++;
            }
            temp.sort((p1, p2) -> {
                if (p2.ability != p1.ability) {
                    return p2.ability - p1.ability;
                } else {
                    return p1.id - p2.id;
                }
            });
            for (int j = 0; j < players / 2; j++) {
                leagues.get(i).best.add(temp.get(j));
            }
            for (int j = players / 2; j < players; j++) {
                leagues.get(i).worst.add(temp.get(j));
            }
        }
        for (League league : leagues) {
            System.out.println(league.best);
            System.out.println(league.worst);
        }
    }

    int move() {
        int sum = 0;
        List<Player> tp = new ArrayList<>();
        tp.add(leagues.get(0).worst.pollFirst());
        for (int i = 1; i < L - 2; i++) {
            tp.add(leagues.get(i).best.pollFirst());
            tp.add(leagues.get(i).worst.pollFirst());
        }
        tp.add(leagues.get(L - 1).best.pollFirst());
        for (int i = 0; i < L; i++) {
            sum += tp.get(i).ability;
        }
        System.out.println(sum);
        return sum;
    }

    int trade() {
        return 0;
    }

    static class Player {
        int id;
        int ability;

        public Player(int id, int ability) {
            this.id = id;
            this.ability = ability;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id=" + id +
                    ", ability=" + ability +
                    '}';
        }
    }

    static class League {
        TreeSet<Player> best = new TreeSet<>((p1, p2) -> {
                if (p2.ability != p1.ability) {
                    return p2.ability - p1.ability;
                } else {
                    return p1.id - p2.id;
                }
            });
        TreeSet<Player> worst = new TreeSet<>((p1, p2) -> {
                if (p2.ability != p1.ability) {
                    return p2.ability - p1.ability;
                } else {
                    return p1.id - p2.id;
                }
            });

        void addPlayer(Player player) {
            if (best.getLast().ability > player.ability) {
                worst.add(player);
            } else if (best.getLast().ability == player.ability) {
                if (best.getLast().id < player.id) {
                    worst.add(player);
                } else {

                }
            }
        }

        public void trade(Player good, Player bad) {
            if (good.ability > best.getLast().ability) {
//                worst.
            }
        }
    }
}