package interface_adapter.bet_recommendation;



public class RecommendState {
    private String username = "";
    private String inputA = "";

    private String inputAerror = null;



    public RecommendState(RecommendState copy){
        inputA = copy.inputA;
        inputAerror = copy.inputAerror;
        username = copy.username;
    }
    public RecommendState(){}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getInputA() {return inputA;}

    public String getInputAerror() {
        return inputAerror;
    }
    public void setInputA(String inputA){this.inputA = inputA;}
}

