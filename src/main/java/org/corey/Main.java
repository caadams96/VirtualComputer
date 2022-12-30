package org.corey;
import org.corey.Circuits.oneBitALU;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void run(int[] b0,int[] b1,oneBitALU alu, int opCode){
       ArrayList<Integer> results = new ArrayList<>();
        for(int i = 7; i>=0; --i){
            alu.setInput(b0[i],b1[i],alu.getCarryIn());
           // alu.setOperation(opCode);
            alu.MULTIPLEXOR(opCode);
            alu.setCarryIn(alu.getCarryOut());
            results.add(alu.getResult());
        }

        for(int i = 7; i>=0;--i){
            System.out.print(results.get(i));

        }
    }
    public static void main(String[] args) {
        ArrayList<oneBitALU> aluList = new ArrayList<>();
        int[] b0 = {0,0,0,0,1,1,1,1};
        int[] b1 = {0,0,0,0,0,0,1,0};
        oneBitALU alu = new oneBitALU();
        run(b0,b1,alu,2);
//        alu.setInput(1,0,0);
//        alu.MULTIPLEXOR(0);
//        System.out.println(alu.getResult());
    }
}