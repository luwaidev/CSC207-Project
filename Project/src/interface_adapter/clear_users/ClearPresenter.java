package interface_adapter.clear_users;

// TODO Complete me

import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

import javax.swing.*;
import java.util.jar.JarEntry;

public class ClearPresenter implements ClearOutputBoundary {
    public ClearPresenter(){

    }

    @Override
    public void prepareSuccessView(ClearOutputData data){

        JOptionPane.showMessageDialog(data.panel, data.users);
    }

    @Override
    public void prepareFailView(ClearOutputData data){

        JOptionPane.showMessageDialog(data.panel, "No Users Cleared");
    }

}
