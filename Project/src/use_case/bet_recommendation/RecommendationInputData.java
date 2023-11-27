package use_case.bet_recommendation;

public class RecommendationInputData {
    private final String fav_player;

    public RecommendationInputData(String favPlayer) {
        this.fav_player = favPlayer;
    }

    String getFav_player(){return this.fav_player;}

}
