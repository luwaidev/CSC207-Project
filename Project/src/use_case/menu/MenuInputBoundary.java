package use_case.menu;

public interface MenuInputBoundary {
    public void openBetPredictor(MenuInputData menuInputData);
    public void openBetHistory(MenuInputData menuInputData);
    public void openBetRecommendation(MenuInputData menuInputData);

    public void logout();

}
