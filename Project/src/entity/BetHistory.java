package entity;

import java.util.*;

public class BetHistory {
    private static final Map<String, Map<String, ArrayList<String>>> betHistory = new HashMap<>();

    public static void setBetHistory(String user, String type, String betOrRec) {
        if (betHistory.containsKey(user)) {
            if (type.equals("teambet") && betHistory.get(user).containsKey("teambet")){
                betHistory.get(user).get("teambet").add(betOrRec);
            } else if (type.equals("teambet")) {
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.get(user).put("teambet", newBets);
                betHistory.get(user).get("teambet").add(betOrRec);

            }

            if (type.equals("reccomendation") && betHistory.get(user).containsKey("reccomendation")){
                betHistory.get(user).get("reccomendation").add(betOrRec);
            } else if (type.equals("reccomendation")) {
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.get(user).put("reccomendation", newBets);
                betHistory.get(user).get("reccomendation").add(betOrRec);
            }
        }else {
            if (type.equals("teambet")) {
                Map<String, ArrayList<String>> newTypes = new HashMap<String, ArrayList<String>>();
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.put(user, newTypes);
                betHistory.get(user).put("teambet", newBets);
                betHistory.get(user).get("teambet").add(betOrRec);
            }else if (type.equals("reccomendation")) {
                Map<String, ArrayList<String>> newTypes = new HashMap<String, ArrayList<String>>();
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.put(user, newTypes);
                betHistory.get(user).put("reccomendation", newBets);
                betHistory.get(user).get("reccomendation").add(betOrRec);
            }
        }
    }
    public static String getBetHistory(String user) {
        if (betHistory.containsKey(user)) {
            StringBuilder displayHistory = new StringBuilder();
            displayHistory.append("TeamBet Prediction History \n");
            int label = 1;
            for (String bet: betHistory.get(user).get("teambet")) {
                displayHistory.append(label).append(". ");
                displayHistory.append(bet).append("\n");
                label = label + 1;
            }
            displayHistory.append(" \n Recommendation Prediction History \n");
            int label2 = 1;
            for (String rec: betHistory.get(user).get("reccomendation")) {
                displayHistory.append(label2).append(". ");
                displayHistory.append(rec).append("\n");
                label2 = label2 + 1;
            }
            return displayHistory.toString();
        }else {
            return null; // Means either the user doesn't exist or the user has no bets
        }
    };
}