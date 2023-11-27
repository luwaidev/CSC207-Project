package entity;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class BetHistory {
    private static final Dictionary<User, ArrayList<String>> betHistory = new Hashtable<>();

    public static void setBetHistory(User user, String bet) {
        if (betHistory.get(user) == null) {
            ArrayList<String> newBets = new ArrayList<String>();
            betHistory.put(user, newBets);
        }else {
            betHistory.get(user).add(bet);
        }
    }
    public ArrayList<String> getBetHistory(User user) {
        if (betHistory.get(user) != null) {
            return betHistory.get(user);
        }else {
            throw new NoSuchElementException("No such user exists!");
        }
    };
}