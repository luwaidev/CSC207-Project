package data_access;

import entity.Player;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.bet_recommendation.RecommendationDataAccessInterface;
import use_case.player_bet_predictor.PlayerTeamDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerDataAccessObject implements PlayerTeamDataAccessInterface, RecommendationDataAccessInterface {

    public static void main(String[] args) {
        Player player1 = getPlayerStats(getPlayerID("Russell", "Westbrook"));
        System.out.println(player1);
        // System.out.println(player1.getName);
    }
    public static int getPlayerID(String first, String last) {
        int id = -1;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://balldontlie.io/api/v1/players?search=" + first + "&per_page=100")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray responseArray = responseBody.getJSONArray("data");
            for (int i = 0; i < responseArray.length(); i ++) {
                JSONObject player = responseArray.getJSONObject(i);
                if (player.getString("first_name").equals(first) && player.getString("last_name").equals(last)) {
                    id = player.getInt("id");
                    break; // Exit the loop once the player is found
                }
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    public static Player getPlayerStats(int playerId) throws JSONException {
        ArrayList<Integer> points = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.balldontlie.io/api/v1/stats?seasons[]=" + 2018 + "&player_ids[]=" + playerId)
                .get()
                .build();
        try {

            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray responseArray = responseBody.getJSONArray("data");

            if (!responseArray.isEmpty()) {
                JSONObject playerData = responseArray.getJSONObject(0).getJSONObject("player");
                int playerIdFromResponse = playerData.getInt("id");
                System.out.println("Player ID from response: " + playerIdFromResponse);

                points = getPlayerPoints(responseArray, playerId);
            } else {
                System.out.println("No data found for playerId: " + playerId);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Player(playerId, points);
    }

    private static ArrayList<Integer> getPlayerPoints(JSONArray games, int playerId) {
        ArrayList<Integer> playerPoints = new ArrayList<>();

        // assuming that if their points are null (and not int 0), player did not participate in game.
        for (int i = 0; i < games.length(); i++) {
            JSONObject game = games.getJSONObject(i);
            JSONObject playerInfo = game.getJSONObject("player");

            if (playerInfo.getInt("id") == playerId && !game.isNull("pts")) {
                playerPoints.add(game.getInt("pts"));
            }
        }
        return playerPoints;
    }

    @Override
    public double player_avg(Player player) {
        return player.getAvgPoints();
    }
}
