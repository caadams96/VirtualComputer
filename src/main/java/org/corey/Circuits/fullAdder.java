package org.corey.Circuits;
import  org.corey.LogicGates.*;
public class fullAdder {
    private int
            a,b,carryIn,carryOut,sum;
    private final andLogicGate
            AG_0 = new andLogicGate(),
            AG_1 = new andLogicGate(),
            AG_2 = new andLogicGate();
    private final orLogicGate
            OG_0 = new orLogicGate(),
            OG_1 = new orLogicGate();
    public fullAdder(){}
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public void setInput(int a, int b, int carryIn){
        this.a = a;
        this.b = b;
        this.carryIn = carryIn;
        calculate();
    }
    public void setCarryIn(int carryIn) {
        this.carryIn = carryIn;
    }
    public void calculate(){
        int[] inputs = {a,b,carryIn};
        int j = 0;
        int x,y,z;

        //Count how many 1's are for inputs
        for(int i = 0; i<=inputs.length-1; ++i){
            if(inputs[i] == 1){
                ++j;
            }
        }
        /*
         ************************************************
         * IF
         *   there is absolutely one input that is 1
         *   or
         *   all inputs are 1
         * THEN
         *   SUM is 1
         * ELSE
         *   SUM is 0
         ************************************************
         * */
        if(j == 1 || j == 3){
            sum = 1;
        }else{
            sum = 0;
        }
        /*
         **************************
         * Take a, b, and the CarryIn
         * and place them in the AND Logic gate
         * store output in temp variables x,y,z
         * calculate Carryout by inputting
         *   x and y in an OR logic gate
         *   and input the OR gate holding x and y
         *   with z into another OR gate to find CarryOut
         * ***********************/
        AG_0.setInput(carryIn,a);
        AG_1.setInput(carryIn,b);
        AG_2.setInput(a,b);

        x =  AG_0.getOutput();
        y =  AG_1.getOutput();
        z =  AG_2.getOutput();

        OG_0.setInput(x,y);
        OG_1.setInput(OG_0.getOutput(),z);
        carryOut = OG_1.getOutput();
    }

    public int getCarryOut() {
        return carryOut;
    }

    public int getSum() {
        return sum;
    }
}
