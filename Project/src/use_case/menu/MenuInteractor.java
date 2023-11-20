package use_case.menu;

public class MenuInteractor implements MenuInputBoundary{

    final MenuOutputBoundary menuPresenter;
    public MenuInteractor(MenuOutputBoundary menuOutputBoundary){
        this.menuPresenter = menuOutputBoundary;
    }

    @Override
    public void openBetPredictor(){
        menuPresenter.openBetPredictor();
    }

}
