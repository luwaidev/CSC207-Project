package entity;

import java.util.*;

public class BetHistory {
    private static final Dictionary<String, ArrayList<String>> betHistory = new Hashtable<>();

    public static void setBetHistory(String user, String bet) {
        if (betHistory.get(user) == null) {
            ArrayList<String> newBets = new ArrayList<String>();
            betHistory.put(user, newBets);
        }else {
            betHistory.get(user).add(bet);
        }
    }
    public static ArrayList<String> getBetHistory(String user) {
        if (betHistory.get(user) != null) {
            return betHistory.get(user);
        }else {
            throw new NoSuchElementException("No such user exists!");
        }
    };
}