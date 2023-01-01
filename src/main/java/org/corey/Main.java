package org.corey;
import org.corey.Circuits.oneBitALU;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {





    public static void run(oneBitALU alu,int[] b0,int[] b1, int opCode, int binvert){
       ArrayList<Integer> results = new ArrayList<>();

        int j = 0;

        if(binvert == 1){
            alu.setCarryIn(1);
        }

        /**CARRY IN
         * ******************/

        //////////////////////

        for(int i = 31; i>=0; --i){
            alu.setInput(b0[i],b1[i],alu.getCarryIn());
            /**BINVERT
             * ******************/
            alu.setBinvert(binvert);
            /////////////////////////

            alu.setOperation(opCode);

            alu.setCarryIn(alu.getCarryOut());
            results.add(alu.getResult());
        }

        for(int i = 31; i>=0;--i){
            System.out.print(results.get(i));
        }
    }

public static void add(oneBitALU alu, int[] b0, int[] b1){
    run(alu,b0,b1,2,0);

}
    public static void subtract(oneBitALU alu, int[] b0, int[] b1){
        run(alu,b0,b1,2,1);

    }
    public static void main(String[] args) {
        oneBitALU alu = new oneBitALU();
        //int[] b0 = {1,1,1,1 ,1,1,1,1, 1,1,1,1, 1,1,1,1,  1,1,1,1, 1,1,1,1,  1,1,1,1,  1,1,1,0};
//        int[] b0 = {0,0,0,0 ,0,0,0,0, 0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,1,  0,0,0,0,  0,0,0,0};
//        int[] b1 = {0,0,0,0 ,0,0,0,0, 0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,1,0,  1,1,0,0,  0,1,0,1};


        int[] b0 = {0,0,0,0 ,0,0,0,0, 0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0,  0,0,0,0,  0,0,1,1};
        int[] b1 = {0,0,0,0 ,0,0,0,0, 0,0,0,0, 0,0,0,0,  0,0,0,0, 0,0,0,0,  0,0,0,0,  1,0,0,0};
        //run(alu,b0,b1,2,1);
        add(alu,b0,b1);
        System.out.println("");
        subtract(alu,b0,b1);

        System.out.println("");






    }

/////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int BinToDecimal(int[] binArray){
        byte n = 0, currentBit, BASE_2;
        byte result = 0;
        for(int i = binArray.length-1; i>=0;--i ){
            currentBit = (byte) binArray[i];
            BASE_2 = (byte) Math.pow(2,n);
            result += currentBit * BASE_2;
            ++n;
        }
        if(result<0){
            ++result;
        }
        return result;
    }


    public static int[] DecToBinary(int decimal){
        ArrayList<Integer> binArray = new ArrayList<>();
        int quotient,remainder;
        int z = decimal;
        for(;;){
            quotient = z/2;
            remainder = z%2;
            binArray.add(remainder);
            z = quotient;
            if(quotient == 0){
                break;
            }
        }
        int[] newArray = new int [binArray.size()];
        int j = 0;
        for(int i = binArray.size()-1; i>=0; --i){
            newArray[j] = binArray.get(i);
            ++j;
        }
        return newArray;
    }
}