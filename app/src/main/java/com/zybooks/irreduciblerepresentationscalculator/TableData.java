package com.zybooks.irreduciblerepresentationscalculator;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TableData
{
    private String element;
    private ArrayList<ArrayList<String>> charTable = new ArrayList<ArrayList<String>>();
    private String result;
    private Context context;

    public TableData(Context context, String element)
    {
        this.element = element;
        this.context = context;
        result = ""; // will be something like "2A1 + B2" eventually
        try{
            InputStream is = context.getResources().openRawResource(context.getResources().getIdentifier(element, "raw", context.getPackageName()));
            //CSVReader reader = new CSVReader(new FileReader(element+".csv"));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );
            String fileInfo = "";
            String nextLine;
            while((nextLine = reader.readLine()) != null){
                String[] tokens = nextLine.split(",");
                ArrayList<String> ob = new ArrayList<>();
                for (int i = 0; i < tokens.length; i++){
                    ob.add(tokens[i]);
                }
                charTable.add(ob);
            }
        } catch (IOException e){

        }

        /*switch (element){
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

            case "c3v":
                // c2v's charTable, first row is coefficients of E, C2, etc
                // other rows are the values in the table (A1's are +1, +1, +1, +1)
                // is a 2d object array because row names vary by element so have to store as String
                // charTable [0][0] stores the value used for h in the equation
                charTable = new Object[5][4];
                charTable[0][0] = 6;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 3;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1;
                charTable[3][0] = "E";  charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0;
                break;

            case "c4v":
                // Number of symmetry elements	h = 8
                // C4v	E	2C4(z)	C2	2v	2d
                // A1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	+1	-1
                // B2	+1	-1	+1	-1	+1
                // E	+2	0	-2	0	0
                charTable = new Object[6][6];
                charTable[0][0] = 8;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 1; charTable[0][4] = 2; charTable[0][5] = 2;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = 1; charTable[3][5] = 1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1;
                charTable[5][0] = "E";  charTable[5][1] = 2; charTable[5][2] = 0; charTable[5][3] = -2; charTable[5][4] = 0; charTable[5][5] = 0;
                break;

            case "c6v":
                // Number of symmetry elements	h = 12
                // C6v	E	2C6 (z)	2C3 (z)	C2 (z)	3v	3d
                // A1	+1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	-1	+1	-1
                // B2	+1	-1	+1	-1	-1	+1
                // E1	+2	+1	-1	-2	0	0
                // E2	+2	-1	-1	+2	0	0
                charTable = new Object[7][7];
                charTable[0][0] = 12;   charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 2; charTable[0][4] = 1; charTable[0][5] = 3; charTable[0][6] = 3;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = 1; charTable[2][5] = -1; charTable[2][6] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = -1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = -1; charTable[4][6] = 1;
                charTable[5][0] = "E1"; charTable[5][1] = 2; charTable[5][2] = -1; charTable[5][3] = -1; charTable[5][4] = 2; charTable[5][5] = 0; charTable[5][6] = 0;
                charTable[6][0] = "E2"; charTable[6][1] = 2; charTable[6][2] = -1; charTable[6][3] = -1; charTable[6][4] = 2; charTable[6][5] = 0; charTable[6][6] = 0;
                break;

            case "c2h":
                // Number of symmetry elements	h = 4
                // C2h	E	C2 (z)	i	h
                // Ag	+1	+1	+1	+1
                // Bg	+1	-1	+1	-1
                // Au	+1	+1	-1	-1
                // Bu	+1	-1	-1	+1
                charTable = new Object[5][5];
                charTable[0][0] = 4;    charTable[0][1] = 1; charTable[0][2] = 1; charTable[0][3] = 1; charTable[0][4] = 1;
                charTable[1][0] = "Ag"; charTable[1][1] = 1; charTable[1][2] = -1; charTable[1][3] = 1; charTable[1][4] = -1;
                charTable[2][0] = "Bg"; charTable[2][1] = 1; charTable[2][2] = -1; charTable[2][3] = 1; charTable[2][4] = -1;
                charTable[3][0] = "Au"; charTable[3][1] = 1; charTable[3][2] = 1; charTable[3][3] = -1; charTable[3][4] = -1;
                charTable[4][0] = "Bu"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = -1; charTable[4][4] = 1;
                break;

            case "d2":
                // Number of symmetry elements	h = 4
                // D2	E	C2 (z)	C2 (y)	C2 (x)
                // A	+1	+1	+1	+1
                // B1	+1	+1	-1	-1
                // B2	+1	-1	+1	-1
                // B3	+1	-1	-1	+1
                charTable = new Object[5][5];
                charTable[0][0] = 4;    charTable[0][1] = 1; charTable[0][2] = 1; charTable[0][3] = 1; charTable[0][4] = 1;
                charTable[1][0] = "A";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1;
                charTable[2][0] = "B1"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = -1;
                charTable[3][0] = "B2"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1;
                charTable[4][0] = "B3"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = -1; charTable[4][4] = 1;
                break;

            case "d3":
                // Number of symmetry elements	h = 6
                // D3	E	2C3 (z)	3C'2
                // A1	+1	+1	+1
                // A2	+1	+1	-1
                // E	+2	-1	0
                charTable = new Object[4][4];
                charTable[0][0] = 6;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 3;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1;
                charTable[3][0] = "E";  charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0;
                break;

            case "d4":
                // Number of symmetry elements	h = 8
                // D4	E	2C4 (z)	C2 (z)	2C'2	2C''2
                // A1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	+1	-1
                // B2	+1	-1	+1	-1	+1
                // E	+2	0	-2	0	0
                charTable = new Object[6][6];
                charTable[0][0] = 8;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 1; charTable[0][4] = 2; charTable[0][5] = 2;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = 1; charTable[3][5] = 1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1;
                charTable[5][0] = "E";  charTable[5][1] = 2; charTable[5][2] = 0; charTable[5][3] = -2; charTable[5][4] = 0; charTable[5][5] = 0;
                break;

            case "d6":
                // Number of symmetry elements	h = 12
                // D6	E	2C6 (z)	2C3 (z)	C2 (z)	3C'2	3C''2
                // A1	+1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	-1	+1	-1
                // B2	+1	-1	+1	-1	-1	+1
                // E1	+2	+1	-1	-2	0	0
                // E2	+2	-1	-1	+2	0	0
                charTable = new Object[7][7];
                charTable[0][0] = 12;   charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 2; charTable[0][4] = 1; charTable[0][5] = 3; charTable[0][6] = 3;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = 1; charTable[2][5] = -1; charTable[2][6] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = -1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = -1; charTable[4][6] = 1;
                charTable[5][0] = "E1"; charTable[5][1] = 2; charTable[5][2] = 1; charTable[5][3] = -1; charTable[5][4] = -2; charTable[5][5] = 0; charTable[5][6] = 0;
                charTable[6][0] = "E2"; charTable[6][1] = 2; charTable[6][2] = -1; charTable[6][3] = -1; charTable[6][4] = 2; charTable[6][5] = 0; charTable[6][6] = 0;
                break;

            case "d2d":
                // Number of symmetry elements	h = 8
                // D2d	E	2S4	C2 (z)	2C'2	2d
                // A1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	+1	-1
                // B2	+1	-1	+1	-1	+1
                // E	+2	0	-2	0	0
                charTable = new Object[6][6];
                charTable[0][0] = 8;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 1; charTable[0][4] = 2; charTable[0][5] = 2;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = 1; charTable[3][5] = -1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1;
                charTable[5][0] = "E";  charTable[5][1] = 2; charTable[5][2] = 0; charTable[5][3] = -2; charTable[5][4] = 0; charTable[5][5] = 0;
                break;

            case "d3d":
                // Number of symmetry elements	h = 12
                // D3d	E	2C3	3C'2	i	2S6	3d
                // A1g	+1	+1	+1	+1	+1	+1
                // A2g	+1	+1	-1	+1	+1	-1
                // Eg	+2	-1	0	+2	-1	0
                // A1u	+1	+1	+1	-1	-1	-1
                // A2u	+1	+1	-1	-1	-1	+1
                // Eu	+2	-1	0	-2	+1	0
                charTable = new Object[7][7];
                charTable[0][0] = 12;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 3; charTable[0][4] = 1; charTable[0][5] = 2; charTable[0][6] = 3;
                charTable[1][0] = "A1g"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1;
                charTable[2][0] = "A2g"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = 1; charTable[2][5] = 1; charTable[2][6] = -1;
                charTable[3][0] = "Eg";  charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0; charTable[3][4] = 2; charTable[3][5] = -1; charTable[3][6] = 0;
                charTable[4][0] = "A1u"; charTable[4][1] = 1; charTable[4][2] = 1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = -1; charTable[4][6] = -1;
                charTable[5][0] = "A2u"; charTable[5][1] = 1; charTable[5][2] = 1; charTable[5][3] = -1; charTable[5][4] = -1; charTable[5][5] = -1; charTable[5][6] = 1;
                charTable[6][0] = "Eu";  charTable[6][1] = 2; charTable[6][2] = -1; charTable[6][3] = 0; charTable[6][4] = -2; charTable[6][5] = 1; charTable[6][6] = 0;
                break;

            case "d4d":
                // Number of symmetry elements	h = 16
                // D4d	E	2S8	2C4	2(S8)3	C2	4C'2	4d
                // A1	+1	+1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	-1	+1	+1	-1
                // B2	+1	-1	+1	-1	+1	-1	+1
                // E1	+2	+(2)½	0	-(2)½	-2	0	0
                // E2	+2	0	-2	0	+2	0	0
                // E3	+2	-(2)½	0	+(2)½	-2	0	0
                charTable = new Object[8][8];
                charTable[0][0] = 16;   charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 2; charTable[0][4] = 2; charTable[0][5] = 1; charTable[0][6] = 4; charTable[0][7] = 4;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = 1; charTable[2][5] = 1; charTable[2][6] = -1; charTable[2][7] = -1;
                charTable[3][0] = "B1"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = 1; charTable[3][7] = -1;
                charTable[4][0] = "B2"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1; charTable[4][6] = -1; charTable[4][7] = 1;
                charTable[5][0] = "E1"; charTable[5][1] = 2; charTable[5][2] = Math.pow(2,0.5); charTable[5][3] = 0; charTable[5][4] = -1*Math.pow(2,0.5); charTable[5][5] = -2; charTable[5][6] = 0; charTable[5][7] = 0;
                charTable[6][0] = "E2"; charTable[6][1] = 2; charTable[6][2] = 0; charTable[6][3] = -2; charTable[6][4] = 0; charTable[6][5] = 2; charTable[6][6] = 0; charTable[6][7] = 0;
                charTable[7][0] = "E3"; charTable[7][1] = 2; charTable[7][2] = -1*Math.pow(2,0.5); charTable[7][3] = 0; charTable[7][4] = Math.pow(2,0.5); charTable[7][5] = -2; charTable[7][6] = 0; charTable[7][7] = 0;
                break;

            case "d6d":
                // Number of symmetry elements	h = 24
                // D6d	E	2S12	2C6	2S4	2C3	2(S12)5	C2	6C'2	6d
                // A1	+1	+1	+1	+1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	+1	+1	+1	+1	-1	-1
                // B1	+1	-1	+1	-1	+1	-1	+1	+1	-1
                // B2	+1	-1	+1	-1	+1	-1	+1	-1	+1
                // E1	+2	+(3)½	+1	0	-1	-(3)½	-2	0	0
                // E2	+2	+1	-1	-2	-1	+1	+2	0	0
                // E3	+2	0	-2	0	+2	0	-2	0	0
                // E4	+2	-1	-1	+2	-1	-1	+2	0	0
                // E5	+2	-(3)½	+1	0	-1	+(3)½	-2	0	0
                charTable = new Object[10][10];
                charTable[0][0] = 24;    charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 2; charTable[0][4] = 2; charTable[0][5] = 2; charTable[0][6] = 2; charTable[0][7] = 1; charTable[0][8] = 1; charTable[0][9] = 1;
                charTable[1][0] = "A1";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1; charTable[1][8] = 1; charTable[1][9] = 1;
                charTable[2][0] = "A2";  charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = 1; charTable[2][5] = 1; charTable[2][6] = 1; charTable[2][7] = 1; charTable[2][8] = -1; charTable[2][9] = -1;
                charTable[3][0] = "B1";  charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = -1; charTable[3][7] = 1; charTable[3][8] = 1; charTable[3][9] = -1;
                charTable[4][0] = "B2";  charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1; charTable[4][6] = -1; charTable[4][7] = 1; charTable[4][8] = -1; charTable[4][9] = 1;
                charTable[5][0] = "E1";  charTable[5][1] = 2; charTable[5][2] = Math.pow(3,0.5); charTable[5][3] = 1; charTable[5][4] = 0; charTable[5][5] = -1; charTable[5][6] = -1*Math.pow(3,0.5); charTable[5][7] = -2; charTable[5][8] = 0; charTable[5][9] = 0;
                charTable[6][0] = "E2";  charTable[6][1] = 2; charTable[6][2] = 1; charTable[6][3] = -1; charTable[6][4] = -2; charTable[6][5] = -1; charTable[6][6] = 1; charTable[6][7] = 2; charTable[6][8] = 0; charTable[6][9] = 0;
                charTable[7][0] = "E3";  charTable[7][1] = 2; charTable[7][2] = 0; charTable[7][3] = -2; charTable[7][4] = 0; charTable[7][5] = 2; charTable[7][6] = 0; charTable[7][7] = -2; charTable[7][7] = 0; charTable[7][9] = 0;
                charTable[8][0] = "E4";  charTable[8][1] = 2; charTable[8][2] = -1; charTable[8][3] = -1; charTable[8][4] = 2; charTable[8][5] = -1; charTable[8][6] = -1; charTable[8][7] = 2; charTable[8][7] = 0; charTable[8][9] = 0;
                charTable[9][0] = "E5";  charTable[9][1] = 2; charTable[9][2] = -1*Math.pow(3,0.5); charTable[9][3] = 1; charTable[9][4] = 0; charTable[9][5] = -1; charTable[9][6] = Math.pow(3,0.5); charTable[9][7] = -2; charTable[9][8] = 0; charTable[9][9] = 0;
                break;

            case "d2h":
                // Number of symmetry elements	h = 8
                // D2h	E	C2 (z)	C2 (y)	C2 (x)	i	 (xy)	 (xz)	 (yz)
                // Ag	+1	+1	+1	+1	+1	+1	+1	+1
                // B1g	+1	+1	-1	-1	+1	+1	-1	-1
                // B2g	+1	-1	+1	-1	+1	-1	+1	-1
                // B3g	+1	-1	-1	+1	+1	-1	-1	+1
                // Au	+1	+1	+1	+1	-1	-1	-1	-1
                // B1u	+1	+1	-1	-1	-1	-1	+1	+1
                // B2u	+1	-1	+1	-1	-1	+1	-1	+1
                // B3u	+1	-1	-1	+1	-1	+1	+1	-1
                charTable = new Object[9][9];
                charTable[0][0] = 8;     charTable[0][1] = 1; charTable[0][2] = 1; charTable[0][3] = 1; charTable[0][4] = 1; charTable[0][5] = 1; charTable[0][6] = 1; charTable[0][7] = 1; charTable[0][8] = 1;
                charTable[1][0] = "Ag";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1; charTable[1][8] = 1;
                charTable[2][0] = "B1g"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = -1; charTable[2][5] = 1; charTable[2][6] = 1; charTable[2][7] = -1; charTable[2][8] = -1;
                charTable[3][0] = "B2g"; charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = -1; charTable[3][7] = 1; charTable[3][8] = -1;
                charTable[4][0] = "B3g"; charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = -1; charTable[4][4] = 1; charTable[4][5] = 1; charTable[4][6] = -1; charTable[4][7] = -1; charTable[4][8] = 1;
                charTable[5][0] = "Au";  charTable[5][1] = 1; charTable[5][2] = 1; charTable[5][3] = 1; charTable[5][4] = 1; charTable[5][5] = -1; charTable[5][6] = -1; charTable[5][7] = -1; charTable[5][8] = -1;
                charTable[6][0] = "Blu"; charTable[6][1] = 1; charTable[6][2] = 1; charTable[6][3] = -1; charTable[6][4] = -1; charTable[6][5] = -1; charTable[6][6] = -1; charTable[6][7] = 1; charTable[6][8] = 1;
                charTable[7][0] = "B2u"; charTable[7][1] = 1; charTable[7][2] = -1; charTable[7][3] = 1; charTable[7][4] = -1; charTable[7][5] = -1; charTable[7][6] = 1; charTable[7][7] = -1; charTable[7][7] = 1;
                charTable[8][0] = "B3u"; charTable[8][1] = 1; charTable[8][2] = -1; charTable[8][3] = -1; charTable[8][4] = 1; charTable[8][5] = -1; charTable[8][6] = 1; charTable[8][7] = 1; charTable[8][7] = -1;
                break;

            case "d3h":
                // Number of symmetry elements	h = 12
                // D3h	E	2C3 (z)	3C'2	h (xy)	2S3	3v
                // A'1	+1	+1	+1	+1	+1	+1
                // A'2	+1	+1	-1	+1	+1	-1
                // E'	+2	-1	0	+2	-1	0
                // A''1	+1	+1	+1	-1	-1	-1
                // A''2	+1	+1	-1	-1	-1	+1
                // E''	+2	-1	0	-2	+1	0
                charTable = new Object[7][7];
                charTable[0][0] = 12;     charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 3; charTable[0][4] = 1; charTable[0][5] = 2; charTable[0][6] = 3;
                charTable[1][0] = "A'1";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1;
                charTable[2][0] = "A'2";  charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = 1; charTable[2][5] = 1; charTable[2][6] = -1;
                charTable[3][0] = "E'";   charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0; charTable[3][4] = 2; charTable[3][5] = -1; charTable[3][6] = 0;
                charTable[4][0] = "A\"1"; charTable[4][1] = 1; charTable[4][2] = 1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = -1; charTable[4][6] = -1;
                charTable[5][0] = "A\"2"; charTable[5][1] = 1; charTable[5][2] = 1; charTable[5][3] = -1; charTable[5][4] = -1; charTable[5][5] = -1; charTable[5][6] = 1;
                charTable[6][0] = "E\"";  charTable[6][1] = 2; charTable[6][2] = -1; charTable[6][3] = 0; charTable[6][4] = -2; charTable[6][5] = 1; charTable[6][6] = 0;
                break;

            case "d4h":
                // Number of symmetry elements	h = 16
                // D4h	E	2C4 (z)	C2	2C'2	2C''2	i	2S4	h	2v	2d
                // A1g	+1	+1	+1	+1	+1	+1	+1	+1	+1	+1
                // A2g	+1	+1	+1	-1	-1	+1	+1	+1	-1	-1
                // B1g	+1	-1	+1	+1	-1	+1	-1	+1	+1	-1
                // B2g	+1	-1	+1	-1	+1	+1	-1	+1	-1	+1
                // Eg	+2	0	-2	0	0	+2	0	-2	0	0
                // A1u	+1	+1	+1	+1	+1	-1	-1	-1	-1	-1
                // A2u	+1	+1	+1	-1	-1	-1	-1	-1	+1	+1
                // B1u	+1	-1	+1	+1	-1	-1	+1	-1	-1	+1
                // B2u	+1	-1	+1	-1	+1	-1	+1	-1	+1	-1
                // Eu	+2	0	-2	0	0	-2	0	+2	0	0
                charTable = new Object[11][11];
                charTable[0][0] = 16;     charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 1; charTable[0][4] = 2; charTable[0][5] = 2; charTable[0][6] = 1; charTable[0][7] = 2; charTable[0][8] = 1; charTable[0][9] = 2; charTable[0][10] = 2;
                charTable[1][0] = "A1g";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1; charTable[1][8] = 1; charTable[1][9] = 1; charTable[1][10] = 1;
                charTable[2][0] = "A2g";  charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1; charTable[2][6] = 1; charTable[2][7] = 1; charTable[2][8] = 1; charTable[2][9] = -1; charTable[2][10] = -1;
                charTable[3][0] = "B1g";  charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = 1; charTable[3][5] = -1; charTable[3][6] = 1; charTable[3][7] = -1; charTable[3][8] = 1; charTable[3][9] = 1; charTable[3][10] = -1;
                charTable[4][0] = "B2g";  charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = 1; charTable[4][6] = 1; charTable[4][7] = -1; charTable[4][8] = 1; charTable[4][9] = -1; charTable[4][10] = 1;
                charTable[5][0] = "Eg";   charTable[5][1] = 2; charTable[5][2] = 0; charTable[5][3] = -2; charTable[5][4] = 0; charTable[5][5] = 0; charTable[5][6] = 2; charTable[5][7] = 0; charTable[5][8] = -2; charTable[5][9] = 0; charTable[5][10] = 0;
                charTable[6][0] = "A1u";  charTable[6][1] = 1; charTable[6][2] = 1; charTable[6][3] = 1; charTable[6][4] = 1; charTable[6][5] = 1; charTable[6][6] = -1; charTable[6][7] = -1; charTable[6][8] = -1; charTable[6][9] = -1; charTable[6][10] = -1;
                charTable[7][0] = "A2u";  charTable[7][1] = 1; charTable[7][2] = 1; charTable[7][3] = 1; charTable[7][4] = -1; charTable[7][5] = -1; charTable[7][6] = -1; charTable[7][7] = -1; charTable[7][7] = -1; charTable[7][9] = 1; charTable[7][10] = 1;
                charTable[8][0] = "B1u";  charTable[8][1] = 1; charTable[8][2] = -1; charTable[8][3] = 1; charTable[8][4] = 1; charTable[8][5] = -1; charTable[8][6] = -1; charTable[8][7] = 1; charTable[8][7] = -1; charTable[8][9] = -1; charTable[8][10] = 1;
                charTable[9][0] = "B2u";  charTable[9][1] = 1; charTable[9][2] = -1; charTable[9][3] = 1; charTable[9][4] = -1; charTable[9][5] = 1; charTable[9][6] = -1; charTable[9][7] = 1; charTable[9][8] = -1; charTable[9][9] = 1; charTable[9][10] = -1;
                charTable[10][0] = "Eu";  charTable[10][1] = 2; charTable[10][2] = 0; charTable[10][3] = -2; charTable[10][4] = 0; charTable[10][5] = 0; charTable[10][6] = -2; charTable[10][7] = 0; charTable[10][8] = 2; charTable[10][9] = 0; charTable[10][10] = 0;
                break;


            case "d6h":
                // Number of symmetry elements	h = 24
                // D6h	E	2C6 (z)	2C3	C2	3C'2	3C''2	i	2S3	2S6	h (xy)	3d	3v
                // A1g	+1	+1	+1	+1	+1	+1	+1	+1	+1	+1	+1	+1
                // A2g	+1	+1	+1	+1	-1	-1	+1	+1	+1	+1	-1	-1
                // B1g	+1	-1	+1	-1	+1	-1	+1	-1	+1	-1	+1	-1
                // B2g	+1	-1	+1	-1	-1	+1	+1	-1	+1	-1	-1	+1
                // E1g	+2	+1	-1	-2	0	0	+2	+1	-1	-2	0	0
                // E2g	+2	-1	-1	+2	0	0	+2	-1	-1	+2	0	0
                // A1u	+1	+1	+1	+1	+1	+1	-1	-1	-1	-1	-1	-1
                // A2u	+1	+1	+1	+1	-1	-1	-1	-1	-1	-1	+1	+1
                // B1u	+1	-1	+1	-1	+1	-1	-1	+1	-1	+1	-1	+1
                // B2u	+1	-1	+1	-1	-1	+1	-1	+1	-1	+1	+1	-1
                // E1u	+2	+1	-1	-2	0	0	-2	-1	+1	+2	0	0
                // E2u	+2	-1	-1	+2	0	0	-2	+1	+1	-2	0	0
                charTable = new Object[13][13];
                charTable[0][0] = 24;     charTable[0][1] = 1; charTable[0][2] = 2; charTable[0][3] = 2; charTable[0][4] = 1; charTable[0][5] = 3; charTable[0][6] = 3; charTable[0][7] = 1; charTable[0][8] = 2; charTable[0][9] = 2; charTable[0][10] = 1; charTable[0][11] = 3; charTable[0][12] = 3;
                charTable[1][0] = "A1g";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1; charTable[1][8] = 1; charTable[1][9] = 1; charTable[1][10] = 1; charTable[1][11] = 3; charTable[1][12] = 3;
                charTable[2][0] = "A2g";  charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = 1; charTable[2][5] = -1; charTable[2][6] = -1; charTable[2][7] = 1; charTable[2][8] = 1; charTable[2][9] = 1; charTable[2][10] = 1; charTable[2][11] = -1; charTable[2][12] = -1;
                charTable[3][0] = "B1g";  charTable[3][1] = 1; charTable[3][2] = -1; charTable[3][3] = 1; charTable[3][4] = -1; charTable[3][5] = 1; charTable[3][6] = -1; charTable[3][7] = 1; charTable[3][8] = -1; charTable[3][9] = 1; charTable[3][10] = -1; charTable[3][11] = 1; charTable[3][12] = -1;
                charTable[4][0] = "B2g";  charTable[4][1] = 1; charTable[4][2] = -1; charTable[4][3] = 1; charTable[4][4] = -1; charTable[4][5] = -1; charTable[4][6] = 1; charTable[4][7] = 1; charTable[4][8] = -1; charTable[4][9] = 1; charTable[4][10] = -1; charTable[4][11] = -1; charTable[4][12] = 1;
                charTable[5][0] = "E1g";  charTable[5][1] = 2; charTable[5][2] = 1; charTable[5][3] = -1; charTable[5][4] = -2; charTable[5][5] = 0; charTable[5][6] = 0; charTable[5][7] = 2; charTable[5][8] = 1; charTable[5][9] = -1; charTable[5][10] = -2; charTable[5][11] = 0; charTable[5][12] = 0;
                charTable[6][0] = "E2g";  charTable[6][1] = 2; charTable[6][2] = -1; charTable[6][3] = -1; charTable[6][4] = 2; charTable[6][5] = 0; charTable[6][6] = 0; charTable[6][7] = 2; charTable[6][8] = -1; charTable[6][9] = -1; charTable[6][10] = 2; charTable[6][11] = 0; charTable[6][12] = 0;
                charTable[7][0] = "A1u";  charTable[7][1] = 1; charTable[7][2] = 1; charTable[7][3] = 1; charTable[7][4] = 1; charTable[7][5] = 1; charTable[7][6] = 1; charTable[7][7] = -1; charTable[7][7] = -1; charTable[7][9] = -1; charTable[7][10] = -1; charTable[7][11] = -1; charTable[7][12] = -1;
                charTable[8][0] = "A2u";  charTable[8][1] = 1; charTable[8][2] = 1; charTable[8][3] = 1; charTable[8][4] = 1; charTable[8][5] = -1; charTable[8][6] = -1; charTable[8][7] = -1; charTable[8][7] = -1; charTable[8][9] = -1; charTable[8][10] = -1; charTable[8][11] = 1; charTable[8][12] = 1;
                charTable[9][0] = "B1u";  charTable[9][1] = 1; charTable[9][2] = -1; charTable[9][3] = 1; charTable[9][4] = -1; charTable[9][5] = 1; charTable[9][6] = -1; charTable[9][7] = -1; charTable[9][8] = 1; charTable[9][9] = -1; charTable[9][10] = 1; charTable[9][11] = -1; charTable[9][12] = 1;
                charTable[10][0] = "B2u"; charTable[10][1] = 1; charTable[10][2] = -1; charTable[10][3] = 1; charTable[10][4] = -1; charTable[10][5] = -1; charTable[10][6] = 1; charTable[10][7] = -1; charTable[10][8] = 1; charTable[10][9] = -1; charTable[10][10] = 1; charTable[10][11] = 1; charTable[10][12] = -1;
                charTable[11][0] = "E1u"; charTable[11][1] = 2; charTable[11][2] = 1; charTable[11][3] = -1; charTable[11][4] = -2; charTable[11][5] = 0; charTable[11][6] = 0; charTable[11][7] = -2; charTable[11][8] = -1; charTable[11][9] = 1; charTable[11][10] = 2; charTable[11][11] = 0; charTable[11][12] = 0;
                charTable[12][0] = "E2u"; charTable[12][1] = 2; charTable[12][2] = -1; charTable[12][3] = -1; charTable[12][4] = 2; charTable[12][5] = 0; charTable[12][6] = 0; charTable[12][7] = -2; charTable[12][8] = 1; charTable[12][9] = 1; charTable[12][10] = -2; charTable[12][11] = 0; charTable[12][12] = 0;
                break;

            case "td":
                // Number of symmetry elements	h = 24
                // Td	E	8C3	3C2	6S4	6d
                // A1	+1	+1	+1	+1	+1
                // A2	+1	+1	+1	-1	-1
                // E	+2	-1	+2	0	0
                // T1	+3	0	-1	+1	-1
                // T2	+3	0	-1	-1	+1
                charTable = new Object[6][6];
                charTable[0][0] = 24;   charTable[0][1] = 1; charTable[0][2] = 8; charTable[0][3] = 3; charTable[0][4] = 6; charTable[0][5] = 6;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1;
                charTable[3][0] = "E";  charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 2; charTable[3][4] = 0; charTable[3][5] = 0;
                charTable[4][0] = "T1"; charTable[4][1] = 3; charTable[4][2] = 0; charTable[4][3] = -1; charTable[4][4] = 1; charTable[4][5] = -1;
                charTable[5][0] = "T2"; charTable[5][1] = 3; charTable[5][2] = 0; charTable[5][3] = -1; charTable[5][4] = -1; charTable[5][5] = 1;
                break;

            case "o":
                // Number of symmetry elements	h = 24
                // O	E	8C3	6C'2	6C4	3C2 =(C4)2
                // A1	+1	+1	+1	+1	+1
                // A2	+1	+1	-1	-1	+1
                // E	+2	-1	0	0	+2
                // T1	+3	0	-1	+1	-1
                // T2	+3	0	+1	-1	-1
                charTable = new Object[6][6];
                charTable[0][0] = 24;   charTable[0][1] = 1; charTable[0][2] = 8; charTable[0][3] = 3; charTable[0][4] = 6; charTable[0][5] = 6;
                charTable[1][0] = "A1"; charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1;
                charTable[2][0] = "A2"; charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = 1; charTable[2][4] = -1; charTable[2][5] = -1;
                charTable[3][0] = "E";  charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0; charTable[3][4] = 0; charTable[3][5] = 2;
                charTable[4][0] = "T1"; charTable[4][1] = 3; charTable[4][2] = 0; charTable[4][3] = -1; charTable[4][4] = 1; charTable[4][5] = -1;
                charTable[5][0] = "T2"; charTable[5][1] = 3; charTable[5][2] = 0; charTable[5][3] = -1; charTable[5][4] = -1; charTable[5][5] = 1;
                break;

            case "oh":
                // Oh	E	8C3	6C2	6C4	3C2 =(C4)2	i	6S4	8S6	3h	6d
                // A1g	+1	+1	+1	+1	+1	+1	+1	+1	+1	+1
                // A2g	+1	+1	-1	-1	+1	+1	-1	+1	+1	-1
                // Eg	+2	-1	0	0	+2	+2	0	-1	+2	0
                // T1g	+3	0	-1	+1	-1	+3	+1	0	-1	-1
                // T2g	+3	0	+1	-1	-1	+3	-1	0	-1	+1
                // A1u	+1	+1	+1	+1	+1	-1	-1	-1	-1	-1
                // A2u	+1	+1	-1	-1	+1	-1	+1	-1	-1	+1
                // Eu	+2	-1	0	0	+2	-2	0	+1	-2	0
                // T1u	+3	0	-1	+1	-1	-3	-1	0	+1	+1
                // T2u	+3	0	+1	-1	-1	-3	+1	0	+1	-1
                charTable = new Object[11][11];
                charTable[0][0] = 48;     charTable[0][1] = 1; charTable[0][2] = 8; charTable[0][3] = 6; charTable[0][4] = 6; charTable[0][5] = 3; charTable[0][6] = 1; charTable[0][7] = 6; charTable[0][8] = 8; charTable[0][9] = 3; charTable[0][10] = 6;
                charTable[1][0] = "A1g";  charTable[1][1] = 1; charTable[1][2] = 1; charTable[1][3] = 1; charTable[1][4] = 1; charTable[1][5] = 1; charTable[1][6] = 1; charTable[1][7] = 1; charTable[1][8] = 1; charTable[1][9] = 1; charTable[1][10] = 1;
                charTable[2][0] = "A2g";  charTable[2][1] = 1; charTable[2][2] = 1; charTable[2][3] = -1; charTable[2][4] = -1; charTable[2][5] = 1; charTable[2][6] = 1; charTable[2][7] = -1; charTable[2][8] = 1; charTable[2][9] = 1; charTable[2][10] = -1;
                charTable[3][0] = "Eg";   charTable[3][1] = 2; charTable[3][2] = -1; charTable[3][3] = 0; charTable[3][4] = 0; charTable[3][5] = 2; charTable[3][6] = 2; charTable[3][7] = 0; charTable[3][8] = -1; charTable[3][9] = 2; charTable[3][10] = 0;
                charTable[4][0] = "T1g";  charTable[4][1] = 3; charTable[4][2] = 0; charTable[4][3] = -1; charTable[4][4] = 1; charTable[4][5] = -1; charTable[4][6] = 3; charTable[4][7] = 1; charTable[4][8] = 0; charTable[4][9] = -1; charTable[4][10] = -1;
                charTable[5][0] = "T2g";  charTable[5][1] = 3; charTable[5][2] = 0; charTable[5][3] = 1; charTable[5][4] = -1; charTable[5][5] = -1; charTable[5][6] = 3; charTable[5][7] = -1; charTable[5][8] = 0; charTable[5][9] = -1; charTable[5][10] = 1;
                charTable[6][0] = "A1u";  charTable[6][1] = 1; charTable[6][2] = 1; charTable[6][3] = 1; charTable[6][4] = 1; charTable[6][5] = 1; charTable[6][6] = -1; charTable[6][7] = -1; charTable[6][8] = -1; charTable[6][9] = -1; charTable[6][10] = -1;
                charTable[7][0] = "A2u";  charTable[7][1] = 1; charTable[7][2] = 1; charTable[7][3] = -1; charTable[7][4] = -1; charTable[7][5] = 1; charTable[7][6] = -1; charTable[7][7] = 1; charTable[7][7] = -1; charTable[7][9] = -1; charTable[7][10] = 1;
                charTable[8][0] = "Eu";   charTable[8][1] = 2; charTable[8][2] = -1; charTable[8][3] = 0; charTable[8][4] = 0; charTable[8][5] = 2; charTable[8][6] = -2; charTable[8][7] = 0; charTable[8][7] = 1; charTable[8][9] = -2; charTable[8][10] = 0;
                charTable[9][0] = "T1u";  charTable[9][1] = 3; charTable[9][2] = 0; charTable[9][3] = -1; charTable[9][4] = 1; charTable[9][5] = -1; charTable[9][6] = -3; charTable[9][7] = -1; charTable[9][8] = 0; charTable[9][9] = 1; charTable[9][10] = 1;
                charTable[10][0] = "T2u"; charTable[10][1] = 3; charTable[10][2] = 0; charTable[10][3] = 1; charTable[10][4] = -1; charTable[10][5] = -1; charTable[10][6] = -3; charTable[10][7] = 1; charTable[10][8] = 0; charTable[10][9] = 1; charTable[10][10] = -1;
                break;

            default:
                charTable = null;
                break;
        }*/
    }

    public void calculate(int[] input)
    {
        // input is an array because the amount of args varies by element
        int h = Integer.parseInt(charTable.get(0).get(0));

        double[] results = new double[charTable.size()-1];
        int rIndex = 0;

        for(int row = 1; row < charTable.size(); row++)
        {
            int index = 0;
            for(int col = 1; col < charTable.get(0).size(); col++)
            {
                results[rIndex] += Integer.parseInt(charTable.get(row).get(col)) * Integer.parseInt(charTable.get(0).get(col)) * input[index];
                //System.out.println(row + " " + col + "  " + (row+1) + " " + col + " " + index);
                index++;
            }
            rIndex++;
        }

        for(int i = 0; i < results.length; i++)
        {
            results[i] /= h;
        }

        boolean reducible = true;
        for(int i = 0; i < results.length; i++) {
            if (results[i] != (int) results[i])
                reducible = false;
        }

        if( reducible )
        {
            for(int i = 0; i < results.length; i++)
            {
                if(results[i] != 0)
                {
                    if (i == 0)
                        result += (int)results[i] + (String)charTable.get(i+1).get(0);
                    else
                        result += " + " + (int)results[i] + charTable.get(i+1).get(0);
                    //System.out.println( results[i] + " " + charTable[i+1][0]);
                }
            }
        }
        else
        {
            System.out.println("Not reducible");
            for(int i = 0; i < results.length; i++)
                if (i == 0) {
                    if ((int) results[i] == 1)
                        result += (String) charTable.get(i + 1).get(0);
                    else
                        result += (int) results[i] + (String) charTable.get(i + 1).get(0);
                }
                else {
                    if ((int) results[i] == 1) {
                        result += "+ " + (String) charTable.get(i + 1).get(0);
                        Log.d("3", "3");
                    }
                    else {
                        result += "+ ";// + (int) results[i] + charTable.get(i + 1).get(0);
                        Log.d("4", "4");
                    }
                }
                //System.out.println(results[i] + " " + charTable[i+1][0]);
        }



    }

    public String getResult(){
        return result;
    }


}
