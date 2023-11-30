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
    public void openBetHistory() {menuPresenter.openBetHistory();}

    @Override
    public void logout(){menuPresenter.logout();}

}
