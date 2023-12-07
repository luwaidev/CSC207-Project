package entity;

import java.util.*;

public class BetHistory {
    private static final Map<String, Map<String, ArrayList<String>>> betHistory = new HashMap<>();

    public static void setBetHistory(String user, String type, String betOrRec) {

        //adds a bet in the case that the user has already been initialized in the betHistory data structure
        if (betHistory.containsKey(user)) {
            // adds team bet's to history
            if (type.equals("teambet") && betHistory.get(user).containsKey("teambet")){
                betHistory.get(user).get("teambet").add(betOrRec);
            } else if (type.equals("teambet")) {
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.get(user).put("teambet", newBets);
                betHistory.get(user).get("teambet").add(betOrRec);
            }

            // adds recommendation's to history
            if (type.equals("reccomendation") && betHistory.get(user).containsKey("reccomendation")){
                betHistory.get(user).get("reccomendation").add(betOrRec);
            } else if (type.equals("reccomendation")) {
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.get(user).put("reccomendation", newBets);
                betHistory.get(user).get("reccomendation").add(betOrRec);
            }

            // adds player bet's to history
            if (type.equals("playerbet") && betHistory.get(user).containsKey("playerbet")) {
                betHistory.get(user).get("playerbet").add(betOrRec);
            } else if (type.equals("playerbet")) {
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.get(user).put("playerbet", newBets);
                betHistory.get(user).get("playerbet").add(betOrRec);
            }

        // adds bets when user has not yet been initialized into data structure
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
            }else if (type.equals("playerbet")) {
                Map<String, ArrayList<String>> newTypes = new HashMap<String, ArrayList<String>>();
                ArrayList<String> newBets = new ArrayList<String>();
                betHistory.put(user, newTypes);
                betHistory.get(user).put("playerbet", newBets);
                betHistory.get(user).get("playerbet").add(betOrRec);
            }
        }
    }
    public static String getBetHistory(String user) {
        if (betHistory.containsKey(user)) {
            StringBuilder displayHistory = new StringBuilder();
            if (betHistory.get(user).containsKey("teambet")) {
                displayHistory.append("TeamBet Prediction History \n");
                int label = 1;
                for (String bet: betHistory.get(user).get("teambet")) {
                    displayHistory.append(label).append(". ");
                    displayHistory.append(bet).append("\n");
                    label = label + 1;
                }
            }

            if (betHistory.get(user).containsKey("reccomendation")) {
                displayHistory.append(" \nRecommendation Prediction History \n");
                int label2 = 1;
                for (String rec: betHistory.get(user).get("reccomendation")) {
                    displayHistory.append(label2).append(". ");
                    displayHistory.append(rec).append("\n");
                    label2 = label2 + 1;
                }
            }

            if (betHistory.get(user).containsKey("playerbet")) {
                displayHistory.append(" \nPlayer Bet History \n");
                int label2 = 1;
                for (String player: betHistory.get(user).get("playerbet")) {
                    displayHistory.append(label2).append(". ");
                    displayHistory.append(player).append("\n");
                    label2 = label2 + 1;
                }
            }
            return displayHistory.toString();
        }else {
            return null; // Means either the user doesn't exist or the user has no bets
        }
    }
}