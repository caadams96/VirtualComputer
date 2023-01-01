package org.corey.LogicGates;

public class inverterLogicGate {
    private int a;
    private int output;
    public void setA(int a) {
        this.a = a;
    }
    public void setInput(int a){
        this.a = a;
        calculate();
    }
    public void calculate(){
        if(a==0){
            output = 1;
        }
        if(a==1){
            output = 0;
        }
    }
    public int getOutput(){
        return output;
    }
}
