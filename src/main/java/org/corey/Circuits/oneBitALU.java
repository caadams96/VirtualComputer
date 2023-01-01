package org.corey.Circuits;
import  org.corey.LogicGates.*;
public class oneBitALU {
    private int a,b;
    private int carryIn;
   private int operation,result;
   private  int carryOut;
    andLogicGate AG_0 = new andLogicGate();
    orLogicGate OG_0 = new orLogicGate();
    inverterLogicGate INV_0 = new inverterLogicGate();
    fullAdder ADDER_0 = new fullAdder();
    public void setInput(int a, int b, int carryIn){
        this.a = a;
        this.b = b;
        this.carryIn = carryIn;
    }

    public void setCarryIn(int carryIn) {
        this.carryIn = carryIn;
    }
    public void setBinvert(int operation){
        switch (operation){
            case 0 ->{}
            case 1 ->{

               INV_0.setInput(b);
              b = INV_0.getOutput();
            }
        }
    }

    public void setOperation(int operation){
        switch (operation) {
            case 0 -> {
                AG_0.setInput(a, b);
                AG_0.calculate();
                result = AG_0.getOutput();
            }
            case 1 -> {
                OG_0.setInput(a, b);
                result = OG_0.getOutput();
            }
            case 2 -> {
                ADDER_0.setInput(a, b, carryIn);
                result = ADDER_0.getSum();
                carryOut = ADDER_0.getCarryOut();
            }
        }
    }
    public int getResult() {
        return result;
    }

    public int getCarryOut() {
        return carryOut;
    }

    public int getCarryIn() {
        return carryIn;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
