package use_case.menu;

public interface MenuOutputBoundary {
    public void openBetPredictor(MenuOutputData menuOutputData);

    public void openBetHistory(MenuOutputData menuOutputData);

    void openBetHistory();

    public void logout();

    public void openBetRecommendation();
}
