package use_case.menu;

public interface MenuOutputBoundary {
    void openBetPredictor(MenuOutputData menuOutputData);

    void openBetHistory(MenuOutputData menuOutputData);
  
    void openBetRecommendation(MenuOutputData menuOutputData);
    void openPlayer(MenuOutputData menuOutputData);

    void logout();

}
