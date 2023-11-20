package use_case.clear_users;

// TODO Complete me

import javax.swing.*;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary userPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface, ClearOutputBoundary clearOutputBoundary){
        this.userDataAccessObject = userDataAccessInterface;
        this.userPresenter = clearOutputBoundary;
    }

    @Override
    public void execute() {
        // Call data access object and delete all users
        userDataAccessObject.clearUsers();

    }

    @Override
    public void execute(ClearInputData inputData) {
        // Call data access object and delete all users
        String clearedUsers = userDataAccessObject.clearUsers();

        // Prepare data and output user data to presenter
        ClearOutputData data = new ClearOutputData(inputData.panel, clearedUsers);

        // Check user data
        if (clearedUsers == "[]"){ // No users cleared
            userPresenter.prepareFailView(data);
        }   else {
            userPresenter.prepareSuccessView(data);
        }
    }
}
