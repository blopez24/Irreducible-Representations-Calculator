package com.zybooks.irreduciblerepresentationscalculator;

public class TableData {
    private String element;
    private Object[][] charTable;
    private String result;

    TableData(String element){
        this.element = element;
        result = ""; // will be something like "2A1 + B2" eventually
        switch (element){
            case "c1":
                // Number of symmetry elements h = 1
                //  C1  E
                //  A   +1
                charTable = new Object[2][2];
                charTable[0][0] = 1;    charTable[0][1] = 1;
                charTable[1][0] = "A";  charTable[1][1] = 1;
                break;

            case "cs":
                // Number of symmetry elements	h = 2
                //  Cs  E   Oh
                //  A'  +1  +1
                //  A'' +1  -1
                charTable = new Object[3][3];
                charTable[0][0] = 2;    charTable[0][1] = 1; charTable[0][2] = 1;
                charTable[1][0] = "A'"; charTable[1][1] = 1; charTable[1][2] = 1;
                charTable[2][0] = "A''"; charTable[2][1] = 1; charTable[2][2] = -1;
                break;

            case "ci":
                // Number of symmetry elements	h = 2
                //  Ci  E   i
                //  Ag  +1  +1
                //  Au  +1  -1
                charTable = new Object[3][3];
                charTable[0][0] = 2;    charTable[0][1] = 1; charTable[0][2] = 1;
                charTable[1][0] = "Ag"; charTable[1][1] = 1; charTable[1][2] = 1;
                charTable[2][0] = "Au"; charTable[2][1] = 1; charTable[2][2] = -1;
                break;

            case "c2":
                // Number of symmetry elements	h = 2
                //  C2  E   C2
                //  A   +1  +1
                //  B   +1  -1
                charTable = new Object[3][3];
                charTable[0][0] = 2;    charTable[0][1] = 1; charTable[0][2] = 1;
                charTable[1][0] = "A"; charTable[1][1] = 1; charTable[1][2] = 1;
                charTable[2][0] = "B"; charTable[2][1] = 1; charTable[2][2] = -1;
                break;

            case "c3":
                // Number of symmetry elements  h = 3
                // Ask Professor
                break;

            case "c4":
                // Number of symmetry elements  h = 4
                // Ask Professor
                break;

            case "c5":
                // Number of symmetry elements  h = 5
                // Ask Professor
                break;

            case "c6":
                // Number of symmetry elements  h = 6
                // Ask Professor
                break;

            case "c2v":
                // c2v's charTable, first row is coefficients of E, C2, etc
                // other rows are the values in the table (A1's are +1, +1, +1, +1)
                // is a 2d object array because row names vary by element so have to store as String
                // charTable [0][0] stores the value used for h in the equation
                charTable = new Object[5][5];
                charTable[0][0] = 4;    charTable[0][1] = 1; charTable[0][2] = 1; charTable[0][3] = 1; charTable[0][4] = 1;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = -1; charTable[4][4] = 1;
                break;
            default:
                charTable = null;
                break;
        }
    }

    public void calculate(int[] input){
        // input is an array because the amount of args varies by element
        int h;
        if(charTable[0][0] instanceof Integer)
            h = (Integer) charTable[0][0];



    }

    public String getResult(){
        return result;
    }


}
