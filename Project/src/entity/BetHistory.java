package entity;

import java.util.*;

public class BetHistory {
    private static final Map<String, ArrayList<String>> betHistory = new HashMap<>();

    public static void setBetHistory(String user, String bet) {
        if (betHistory.containsKey(user)) {
            betHistory.get(user).add(bet);
        }else {
            ArrayList<String> newBets = new ArrayList<String>();
            betHistory.put(user, newBets);
        }
    }
    public static ArrayList<String> getBetHistory(String user) {
        if (betHistory.containsKey(user)) {
            return betHistory.get(user);
        }else {
            throw new NoSuchElementException("No such user exists!");
        }
    };
}