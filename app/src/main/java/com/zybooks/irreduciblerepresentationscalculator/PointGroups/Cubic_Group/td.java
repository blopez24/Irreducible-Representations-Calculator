package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cubic_Group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;
import com.zybooks.irreduciblerepresentationscalculator.TableData;

public class td extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.td);

        TextView td_descr = findViewById(R.id.td_descr);
        td_descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the T<sub>d</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView a = findViewById(R.id.td_8c3);
        a.setText(HtmlCompat.fromHtml("8C<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.td_3c2);
        b.setText(HtmlCompat.fromHtml("3C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.td_6s4);
        c.setText(HtmlCompat.fromHtml("6S<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.td_e_user_input);
        EditText value2 = findViewById(R.id.td_8c3_user_input);
        EditText value3 = findViewById(R.id.td_3c2_user_input);
        EditText value4 = findViewById(R.id.td_6s4_user_input);
        EditText value5 = findViewById(R.id.td_6sd_user_input);

        Button button = findViewById(R.id.td_submit);
        Button reset = findViewById(R.id.td_reset);
        TextView answerText = findViewById(R.id.td_text);
        TextView answer = findViewById(R.id.td_answer);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else {
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(),"td");
            int[] input = new int[5];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());
            input[2] = Integer.parseInt(value3.getText().toString().trim());
            input[3] = Integer.parseInt(value4.getText().toString().trim());
            input[4] = Integer.parseInt(value5.getText().toString().trim());

            td.calculate(input);
            String result = td.getResult();
            answer.setText(result);
        }
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void reset(View view) {
        EditText value1 = findViewById(R.id.td_e_user_input);
        EditText value2 = findViewById(R.id.td_8c3_user_input);
        EditText value3 = findViewById(R.id.td_3c2_user_input);
        EditText value4 = findViewById(R.id.td_6s4_user_input);
        EditText value5 = findViewById(R.id.td_6sd_user_input);

        Button button = findViewById(R.id.td_submit);
        Button reset = findViewById(R.id.td_reset);
        TextView answerText = findViewById(R.id.td_text);
        TextView answer = findViewById(R.id.td_answer);

        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        button.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        reset.setVisibility(View.INVISIBLE);
    }
}
