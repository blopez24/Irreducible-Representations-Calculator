package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

public class c3h extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c3h);

        TextView descr = findViewById(R.id.c3h_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>3h</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView a = findViewById(R.id.c3h_c3);
        a.setText(HtmlCompat.fromHtml("C<sub>3</sub>(z)", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.c3h_c32);
        b.setText(HtmlCompat.fromHtml("(C<sub>3</sub>)<sup>2</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.c3h_s3);
        c.setText(HtmlCompat.fromHtml("S<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.c3h_s35);
        d.setText(HtmlCompat.fromHtml("(S<sub>3</sub>)<sup>5</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c3h_e_user_input);
        EditText value2 = findViewById(R.id.c3h_c3_user_input);
        EditText value3 = findViewById(R.id.c3h_c3_2_user_input);
        EditText value4 = findViewById(R.id.c3h_sh_user_input);
        EditText value5 = findViewById(R.id.c3h_s3_user_input);
        EditText value6 = findViewById(R.id.c3h_s3_5_user_input);

        Button button = findViewById(R.id.c3h_submit);
        TextView answerText = findViewById(R.id.c3h_text);
        TextView answer = findViewById(R.id.c3h_answer);
        Button reset = findViewById(R.id.c3h_reset);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())
                || TextUtils.isEmpty(value5.getText().toString())
                || TextUtils.isEmpty(value6.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(), "c3h");
            int[] input = new int[6];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());
            input[2] = Integer.parseInt(value3.getText().toString().trim());
            input[3] = Integer.parseInt(value4.getText().toString().trim());
            input[4] = Integer.parseInt(value5.getText().toString().trim());
            input[5] = Integer.parseInt(value6.getText().toString().trim());

            hideKeyboard(view);
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
        EditText value1 = findViewById(R.id.c3h_e_user_input);
        EditText value2 = findViewById(R.id.c3h_c3_user_input);
        EditText value3 = findViewById(R.id.c3h_c3_2_user_input);
        EditText value4 = findViewById(R.id.c3h_sh_user_input);
        EditText value5 = findViewById(R.id.c3h_s3_user_input);
        EditText value6 = findViewById(R.id.c3h_s3_5_user_input);

        Button button = findViewById(R.id.c3h_submit);
        TextView answerText = findViewById(R.id.c3h_text);
        TextView answer = findViewById(R.id.c3h_answer);
        Button reset = findViewById(R.id.c3h_reset);

        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        value6.setText("");
        button.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        reset.setVisibility(View.INVISIBLE);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}