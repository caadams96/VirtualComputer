package org.corey.LogicGates;

public class andLogicGate {
    private int a,b,output;
    public andLogicGate(){}
    andLogicGate(int a, int b){
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
        output = a & b;
    }
    public int getOutput(){
        return output;
    };
}
