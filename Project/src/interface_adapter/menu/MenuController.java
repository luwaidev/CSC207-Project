package interface_adapter.menu;

import use_case.menu.MenuInputBoundary;

public class MenuController {
    final MenuInputBoundary menuUseCaseInteractor;
    public MenuController(MenuInputBoundary menuUseCaseInteractor){
        this.menuUseCaseInteractor = menuUseCaseInteractor;
    }

    public void openBetPredictor(){
        menuUseCaseInteractor.openBetPredictor();
    }

    public void openBetHistory() { menuUseCaseInteractor.openBetHistory();}

    public void openBetRecommendation() {menuUseCaseInteractor.openBetRecommendation();}

    public void logout(){menuUseCaseInteractor.logout();}
}
