package Relationships.Aggregation;

import java.util.List;

public class Main {
    static class Player{
        String name;
    }
    class Team{
        List<Player>players;
        void addPlayer(Player p){
            players.add(p);
        }
    }
    public static void main(String[] args) {

    }
}
