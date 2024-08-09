package b형.승강제리그;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class UserSolution {
    static int N;
    static int L;

    void init(int N, int L, int mAbility[]) {
        this.N = N;
        this.L = L;
        int idx = 0;
        int players = N / L;
        List<League> leagues = new ArrayList<>();
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
//        for (League league : leagues) {
//            System.out.println(league.best);
//            System.out.println(league.worst);
//        }
    }

    int move() {

        return 0;
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

        public void trade(Player good, Player bad) {
            if (good.ability > best.getLast().ability) {
                worst.
            }
        }
    }
}