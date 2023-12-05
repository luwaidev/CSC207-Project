package use_case.menu;

public interface MenuOutputBoundary {
    public void openBetPredictor(MenuOutputData menuOutputData);

    public void openBetHistory(MenuOutputData menuOutputData);



    public void logout();

    public void openBetRecommendation();
}
