package com.zybooks.irreduciblerepresentationscalculator.PointGroups;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;
import com.zybooks.irreduciblerepresentationscalculator.TableData;

public class c2v extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2v);
    }


    public void result(View view) {
        EditText value = findViewById(R.id.c2v_e_user_input);
        EditText value2 = findViewById(R.id.c2v_c2_user_input);
        EditText value3 = findViewById(R.id.c2v_sv_user_input);
        EditText value4 = findViewById(R.id.c2v_svp_user_input);

        TableData td = new TableData("c2v");
        int[] input = new int[4];
        input[0] = Integer.parseInt(value.getText().toString().trim());
        input[1] = Integer.parseInt(value2.getText().toString().trim());
        input[2] = Integer.parseInt(value3.getText().toString().trim());
        input[3] = Integer.parseInt(value4.getText().toString().trim());

        td.calculate(input);
        String result = td.getResult();
        Toast.makeText(this, "Result is: "+result, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, Results.class);
        intent.putExtra("value", value.getText());
        intent.putExtra("value2", value2.getText());
        intent.putExtra("value3", value3.getText());
        intent.putExtra("value4", value4.getText());
        startActivity(intent);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
