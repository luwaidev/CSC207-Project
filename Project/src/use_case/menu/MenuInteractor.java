package use_case.menu;

public class MenuInteractor implements MenuInputBoundary{

    final MenuOutputBoundary menuPresenter;
    public MenuInteractor(MenuOutputBoundary menuOutputBoundary){
        this.menuPresenter = menuOutputBoundary;
    }

    @Override
    public void openBetPredictor(MenuInputData menuInputData){
        MenuOutputData menuOutputData = new MenuOutputData(menuInputData.getUsername());
        menuPresenter.openBetPredictor(menuOutputData);
    }

    @Override
    public void openBetHistory(MenuInputData menuInputData) {
        MenuOutputData menuOutputData = new MenuOutputData(menuInputData.getUsername());
        menuPresenter.openBetHistory(menuOutputData);
    }


    @Override
    public void logout(){menuPresenter.logout();}

    @Override
    public void openBetRecommendation(MenuInputData menuInputData){
        MenuOutputData menuOutputData = new MenuOutputData(menuInputData.getUsername());
        menuPresenter.openBetRecommendation(menuOutputData);
    }

}
