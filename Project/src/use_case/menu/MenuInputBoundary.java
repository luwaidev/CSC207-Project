package use_case.menu;

public interface MenuInputBoundary {
    void openBetPredictor(MenuInputData menuInputData);
    void openBetHistory(MenuInputData menuInputData);
    void openBetRecommendation(MenuInputData menuInputData);
    void openPlayer(MenuInputData menuInputData);

    void logout();

}
