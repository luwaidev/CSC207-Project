package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;

import javax.swing.*;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearUseCaseInteractor;

    public ClearController(ClearInputBoundary clearUseCaseInteractor){
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute(){
        clearUseCaseInteractor.execute();
    }
    public void execute(JPanel panel){
        ClearInputData inputData = new ClearInputData((panel));
        clearUseCaseInteractor.execute(inputData);
    }
}
