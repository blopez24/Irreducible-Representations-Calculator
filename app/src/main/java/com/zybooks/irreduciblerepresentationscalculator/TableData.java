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
                    if (i == 0) {
                        if ((int) results[i] == 1)
                            result += (String) charTable.get(i + 1).get(0);
                        else
                            result += (int) results[i] + (String) charTable.get(i + 1).get(0);
                    }
                    else {
                        if ((int) results[i] == 1) {
                            result += " + " + (String) charTable.get(i + 1).get(0);
                        }
                        else {
                            result += " + ";// + (int) results[i] + charTable.get(i + 1).get(0);
                        }
                    }
                }
            }
        }
        else
        {
            result = "The reducible representation cannot be reduced.";
        }



    }

    public String getResult(){
        return result;
    }


}
