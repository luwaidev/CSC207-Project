package interface_adapter.bet_recommendation;



public class RecommendState {
    private String inputA = "";

    private String inputAerror = null;



    public RecommendState(RecommendState copy){
        inputA = copy.inputA;

        inputAerror = copy.inputAerror;



    }
    public RecommendState(){}
    public String getInputA() {return inputA;}


    public String getInputAerror() {
        return inputAerror;
    }
    public void setInputA(String inputA){this.inputA = inputA;}
}

