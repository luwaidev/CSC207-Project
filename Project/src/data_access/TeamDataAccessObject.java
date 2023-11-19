package data_access;

import entity.Team;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamDataAccessObject {
    public static void main(String[] args) {
        System.out.println(getTeamStats(1, 2018));
    }
    public static Team getTeamStats(int teamID, int season) throws JSONException{
        ArrayList<Integer> points = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://balldontlie.io/api/v1/games?seasons[]=" + season + "&team_ids[]=" + teamID)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray responseArray = responseBody.getJSONArray("data");
            //System.out.println(responseArray);
            points = getTeamPoints(responseArray, teamID);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(points);
        return new Team(teamID, points);
    }

    private static ArrayList<Integer> getTeamPoints(JSONArray games, int teamId) {
        ArrayList<Integer> points = new ArrayList<>();

        for (int i = 0; i < games.length(); i++) {
            JSONObject game = games.getJSONObject(i);
            JSONObject homeTeam = game.getJSONObject("home_team");
            JSONObject visitorTeam = game.getJSONObject("visitor_team");

            if (visitorTeam.getInt("id") == teamId) {
                points.add(game.getInt("visitor_team_score"));
            }
            else if (homeTeam.getInt("id") == teamId) {
                points.add(game.getInt("home_team_score"));
            }
        }
        return points;

    }
}
