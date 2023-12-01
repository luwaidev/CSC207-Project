package use_case.player_bet_predictor;

public class PlayerInputData {
    private final String firstName;
    private final String lastName;

    public PlayerInputData(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName(){
        return this.firstName;
    }

    String getLastName(){
        return this.lastName;
    }


}
