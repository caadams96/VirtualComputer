package org.corey.LogicGates;

public class orLogicGate {
    private int a,b,output;
    public orLogicGate(){}
    orLogicGate(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setInput(int a, int b){
        this.a = a;
        this.b = b;
        calculate();
    }
    public void calculate(){

        output = a + b;
        if(output>1){
            output = 1;
        }
    }
    public int getOutput(){
        return output;
    }

}
