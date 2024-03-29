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

public class d4d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d4d);

        TextView descr = findViewById(R.id.d4d_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the D<sub>4d</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView a = findViewById(R.id.d4d_2s8);
        a.setText(HtmlCompat.fromHtml("2S<sub>8</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.d4d_2c4);
        b.setText(HtmlCompat.fromHtml("2C<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.d4d_2s83);
        c.setText(HtmlCompat.fromHtml("2(S<sub>8</sub>)<sup>3</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.d4d_c2);
        d.setText(HtmlCompat.fromHtml("C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView e = findViewById(R.id.d4d_4c2);
        e.setText(HtmlCompat.fromHtml("4C'<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView f = findViewById(R.id.d4d_4sd);
        f.setText(HtmlCompat.fromHtml("4&#963;<sub>d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value0 = findViewById(R.id.d4d_e_user_input);
        EditText value1 = findViewById(R.id.d4d_2s8_user_input);
        EditText value2 = findViewById(R.id.d4d_2c4_user_input);
        EditText value3 = findViewById(R.id.d4d_2s83_user_input);
        EditText value4 = findViewById(R.id.d4d_c2_user_input);
        EditText value5 = findViewById(R.id.d4d_4c2_user_input);
        EditText value6 = findViewById(R.id.d4d_4sd_user_input);

        Button reset = findViewById(R.id.d4d_reset);
        Button button = findViewById(R.id.d4d_submit);
        TextView answerText = findViewById(R.id.d4d_text);
        TextView answer = findViewById(R.id.d4d_answer);

        if (TextUtils.isEmpty(value0.getText().toString())
                || TextUtils.isEmpty(value1.getText().toString())
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

            TableData td = new TableData(getApplicationContext(),"d4d");
            double[] input = new double[7];
            input[0] = Double.parseDouble(value0.getText().toString().trim());
            input[1] = Double.parseDouble(value1.getText().toString().trim());
            input[2] = Double.parseDouble(value2.getText().toString().trim());
            input[3] = Double.parseDouble(value3.getText().toString().trim());
            input[4] = Double.parseDouble(value4.getText().toString().trim());
            input[5] = Double.parseDouble(value5.getText().toString().trim());
            input[6] = Double.parseDouble(value6.getText().toString().trim());

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
        EditText value0 = findViewById(R.id.d4d_e_user_input);
        EditText value1 = findViewById(R.id.d4d_2s8_user_input);
        EditText value2 = findViewById(R.id.d4d_2c4_user_input);
        EditText value3 = findViewById(R.id.d4d_2s83_user_input);
        EditText value4 = findViewById(R.id.d4d_c2_user_input);
        EditText value5 = findViewById(R.id.d4d_4c2_user_input);
        EditText value6 = findViewById(R.id.d4d_4sd_user_input);

        Button reset = findViewById(R.id.d4d_reset);
        Button button = findViewById(R.id.d4d_submit);
        TextView answerText = findViewById(R.id.d4d_text);
        TextView answer = findViewById(R.id.d4d_answer);

        value0.setText("");
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
