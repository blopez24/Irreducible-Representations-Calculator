package com.zybooks.irreduciblerepresentationscalculator;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
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
                results[rIndex] += Double.parseDouble(charTable.get(row).get(col)) * Double.parseDouble(charTable.get(0).get(col)) * input[index];
                index++;
            }
            rIndex++;
        }

        for(int i = 0; i < results.length; i++)
        {
            results[i] /= h;
            Log.i("table", "results " + results[i]);

            // Rounds results to the sixth decimal place
            // Necessary for sin, cos, decimal, and sqrt table values
            results[i] = (double)Math.round((results[i]) * 1000000) / 1000000;
        }

        boolean reducible = true;
        for(int i = 0; i < results.length; i++) {
            if (results[i] != (int) results[i])
                reducible = false;
        }


        if( reducible )
        {
            int[] integerResults = new int[results.length];
            for(int i = 0; i < results.length; i++)
            {
                integerResults[i] = (int)results[i];
            }

            // we currently have total, have to subtract out rot and transl to get vib if Cartesian 3N contains all values
            for(int i = 1; i < charTable.size(); i++)
            {
                int rotCol = charTable.size();
                int translCol = rotCol + 1;
                results[i-1] = results[i-1] - Integer.parseInt(charTable.get(i).get(rotCol)) - Integer.parseInt(charTable.get(i).get(translCol));
            }

            int[] integerResultsVib = new int[results.length];
            for(int i = 0; i < results.length; i++)
            {
                integerResultsVib[i] = (int)results[i];
            }

            result = getResultsFormat(integerResults, "Cartesian 3N:\n") + getResultsFormat(integerResultsVib, "\nVibration:\n");

        }
        else
        {
            result = "The reducible representation cannot be reduced.";
        }
    }

    public void calculate(double[] input)
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
                results[rIndex] += Double.parseDouble(charTable.get(row).get(col)) * Double.parseDouble(charTable.get(0).get(col)) * input[index];
                index++;
            }
            rIndex++;
        }

        for(int i = 0; i < results.length; i++)
        {
            results[i] /= h;
            Log.i("table", "results " + results[i]);

            // Rounds results to the sixth decimal place
            // Necessary for sin, cos, decimal, and sqrt table values
            results[i] = (double)Math.round((results[i]) * 1000000) / 1000000;
        }

        boolean reducible = true;
        for(int i = 0; i < results.length; i++) {
            if (results[i] != (int) results[i])
                reducible = false;
        }


        if( reducible )
        {
            int[] integerResults = new int[results.length];
            for(int i = 0; i < results.length; i++)
            {
                integerResults[i] = (int)results[i];
            }

            // we currently have total, have to subtract out rot and transl to get vib if Cartesian 3N contains all values
            for(int i = 1; i < charTable.size(); i++)
            {
                int rotCol = charTable.size();
                int translCol = rotCol + 1;
                results[i-1] = results[i-1] - Integer.parseInt(charTable.get(i).get(rotCol)) - Integer.parseInt(charTable.get(i).get(translCol));
            }

            int[] integerResultsVib = new int[results.length];
            for(int i = 0; i < results.length; i++)
            {
                integerResultsVib[i] = (int)results[i];
            }

            result = getResultsFormat(integerResults, "Cartesian 3N:\n") + getResultsFormat(integerResultsVib, "\nVibration:\n");

        }
        else
        {
            result = "The reducible representation cannot be reduced.";
        }
    }

    private String getResultsFormat(int[] array, String str)
    {
        //String formattedResults = "Cartesian 3N:\n";
        String formattedResults = str;
        int nonZeroes = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != 0)
            {
                nonZeroes++;
            }
        }

        nonZeroes--;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != 0)
            {
                if(array[i] == 1)
                {
                    formattedResults += charTable.get(i + 1).get(0);
                }
                else
                {
                    formattedResults += array[i] + charTable.get(i + 1).get(0);
                }

                if(nonZeroes > 0)
                {
                    nonZeroes--;
                    formattedResults += " + ";
                }
            }
        }
        return formattedResults;
    }

    public String getResult(){
        return result;
    }
}
