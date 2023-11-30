package interface_adapter.game_history;

import use_case.game_history.GameHistoryInputBoundary;

public class GameHistoryController {
    final GameHistoryInputBoundary gameHistoryUseCaseInteractor;

    public GameHistoryController(GameHistoryInputBoundary gameHistoryUseCaseInteractor){
        this.gameHistoryUseCaseInteractor = gameHistoryUseCaseInteractor;
    }
}
