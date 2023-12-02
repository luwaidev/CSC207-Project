package interface_adapter.bet_recommendation;



public class RecommendState {
    private String inputA = "";
    private String inputB = "";
    private String inputAerror = null;
    private String inputBerror = null;


    public RecommendState(RecommendState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
        inputAerror = copy.inputAerror;
        inputBerror = copy.inputBerror;


    }
    public RecommendState(){}
    public String getInputA() {return inputA;}

    public String getInputB() {
        return inputB;
    }

    public void setInputB(String inputB) {
        this.inputB = inputB;
    }
    public String getInputBerror(){return inputBerror;}

    public String getInputAerror() {
        return inputAerror;
    }
    public void setInputA(String inputA){this.inputA = inputA;}
}

