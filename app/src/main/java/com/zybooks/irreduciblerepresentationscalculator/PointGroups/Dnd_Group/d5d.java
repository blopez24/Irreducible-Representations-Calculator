package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

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

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.TableData;

public class d5d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d5d);

        TextView descr = findViewById(R.id.d5d_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the D<sub>5d</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView a = findViewById(R.id.d5d_2c5);
        a.setText(HtmlCompat.fromHtml("2C<sub>5</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.d5d_2c52);
        b.setText(HtmlCompat.fromHtml("2(C<sub>5</sub>)<sup>2</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.d5d_5c2);
        c.setText(HtmlCompat.fromHtml("5C'<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.d5d_2s103);
        d.setText(HtmlCompat.fromHtml("2(S<sub>10</sub>)<sup>3</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView e = findViewById(R.id.d5d_2s10);
        e.setText(HtmlCompat.fromHtml("2S<sub>10</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView f = findViewById(R.id.d5d_5Sd);
        f.setText(HtmlCompat.fromHtml("5S<sub>d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value0 = findViewById(R.id.d5d_e_user_input);
        EditText value1 = findViewById(R.id.d5d_2c5_user_input);
        EditText value2 = findViewById(R.id.d5d_2c52_user_input);
        EditText value3 = findViewById(R.id.d5d_5c2_user_input);
        EditText value4 = findViewById(R.id.d5d_i_user_input);
        EditText value5 = findViewById(R.id.d5d_2s103_user_input);
        EditText value6 = findViewById(R.id.d5d_2s10_user_input);
        EditText value7 = findViewById(R.id.d5d_5Sd_user_input);

        Button reset = findViewById(R.id.d5d_reset);
        Button button = findViewById(R.id.d5d_submit);
        TextView answerText = findViewById(R.id.d5d_text);
        TextView answer = findViewById(R.id.d5d_answer);

        if (TextUtils.isEmpty(value0.getText().toString())
                || TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())
                || TextUtils.isEmpty(value5.getText().toString())
                || TextUtils.isEmpty(value6.getText().toString())
                || TextUtils.isEmpty(value7.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(),"d5d");
            int[] input = new int[8];
            input[0] = Integer.parseInt(value0.getText().toString().trim());
            input[1] = Integer.parseInt(value1.getText().toString().trim());
            input[2] = Integer.parseInt(value2.getText().toString().trim());
            input[3] = Integer.parseInt(value3.getText().toString().trim());
            input[4] = Integer.parseInt(value4.getText().toString().trim());
            input[5] = Integer.parseInt(value5.getText().toString().trim());
            input[6] = Integer.parseInt(value6.getText().toString().trim());
            input[7] = Integer.parseInt(value7.getText().toString().trim());

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
        EditText value0 = findViewById(R.id.d5d_e_user_input);
        EditText value1 = findViewById(R.id.d5d_2c5_user_input);
        EditText value2 = findViewById(R.id.d5d_2c52_user_input);
        EditText value3 = findViewById(R.id.d5d_5c2_user_input);
        EditText value4 = findViewById(R.id.d5d_i_user_input);
        EditText value5 = findViewById(R.id.d5d_2s103_user_input);
        EditText value6 = findViewById(R.id.d5d_2s10_user_input);
        EditText value7 = findViewById(R.id.d5d_5Sd_user_input);

        Button reset = findViewById(R.id.d5d_reset);
        Button button = findViewById(R.id.d5d_submit);
        TextView answerText = findViewById(R.id.d5d_text);
        TextView answer = findViewById(R.id.d5d_answer);

        value0.setText("");
        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        value6.setText("");
        value7.setText("");
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
