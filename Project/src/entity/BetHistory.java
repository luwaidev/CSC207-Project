package entity;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class BetHistory {
    private final Dictionary<User, ArrayList<String>> betHistory = new Hashtable<>();

    public ArrayList<String> getHistory(User user) {
        if (betHistory.get(user) != null) {
            return betHistory.get(user);
        }else {
            throw new NoSuchElementException("No such user exists!");
        }
    };
    public updateHistory

}