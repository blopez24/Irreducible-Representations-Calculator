package com.zybooks.irreduciblerepresentationscalculator;

public class Calculation {
    private String element;
    private int [] args;
    private Object[][] charTable;

    Calculation(String element, int[] args){
        this.element = element;
        this.args = args; // user input
        switch (element){
            case "c2v":
                // c2v's charTable, first row is coefficients of E, C2, etc
                // other rows are the values in the table (A1's are +1, +1, +1, +1)
                // is a 2d object array because row names vary by element so have to store as String
                charTable = new Object[5][5];
                charTable[0][0] = "C2V";
                charTable[0][1] = 1;
                charTable[0][2] = 1;
                charTable[0][3] = 1;
                charTable[0][4] = 1;
                charTable[1][0] = "A1";
                charTable[1][1] = 1;
                charTable[1][2] = 1;
                charTable[1][3] = 1;
                charTable[1][4] = 1;
                charTable[2][0] = "A2";
                charTable[2][1] = 1;
                charTable[2][2] = 1;
                charTable[2][3] = -1;
                charTable[2][4] = -1;
                charTable[3][0] = "A1";
                charTable[3][1] = 1;
                charTable[3][2] = -1;
                charTable[3][3] = 1;
                charTable[3][4] = -1;
                charTable[4][0] = "A1";
                charTable[4][1] = 1;
                charTable[4][2] = -1;
                charTable[4][3] = -1;
                charTable[4][4] = 1;
                break;
            default:
                charTable = null;
                break;
        }
    }

    public String result(){
        return "Something like 2A1 + B2 eventually";
    }


}
