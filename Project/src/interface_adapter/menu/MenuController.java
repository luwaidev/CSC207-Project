package interface_adapter.menu;

import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInputData;

public class MenuController {
    final MenuInputBoundary menuUseCaseInteractor;
    public MenuController(MenuInputBoundary menuUseCaseInteractor){
        this.menuUseCaseInteractor = menuUseCaseInteractor;
    }

    public void openBetPredictor(String username){
        MenuInputData menuInputData = new MenuInputData(username);
        menuUseCaseInteractor.openBetPredictor(menuInputData);
    }

    public void openBetHistory() { menuUseCaseInteractor.openBetHistory();}

    public void logout(){menuUseCaseInteractor.logout();}
}
