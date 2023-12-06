package interface_adapter.player;

public class PlayerState {
    private String username = "";
    private String inputA = "";
    private String inputB = "";
    public PlayerState(PlayerState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }
    public PlayerState(){

    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getInputA(){
        return inputA;
    }

    public String getInputB(){
        return inputB;
    }

    public void setInputA(String inputA){
        this.inputA = inputA;
    }

    public void setInputB(String inputB){
        this.inputB = inputB;
    }

}
