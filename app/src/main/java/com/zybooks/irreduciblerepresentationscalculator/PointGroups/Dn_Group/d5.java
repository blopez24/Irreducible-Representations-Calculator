package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group;

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
import com.zybooks.irreduciblerepresentationscalculator.TableData;

public class d5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d5);

        TextView descr = findViewById(R.id.d5_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the D<sub>5</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView a = findViewById(R.id.d5_2c5);
        a.setText(HtmlCompat.fromHtml("2C<sub>5</sub>(Z)", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.d5_2c52);
        b.setText(HtmlCompat.fromHtml("2(C<sub>5</sub>)<sup>2</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.d5_5c2);
        c.setText(HtmlCompat.fromHtml("5C'<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.d5_e_user_input);
        EditText value2 = findViewById(R.id.d5_2c5_user_input);
        EditText value3 = findViewById(R.id.d5_2c5_2_user_input);
        EditText value4 = findViewById(R.id.d5_5c2_user_input);

        Button button = findViewById(R.id.d5_submit);
        TextView answerText = findViewById(R.id.d5_text);
        TextView answer = findViewById(R.id.d5_answer);
        Button reset = findViewById(R.id.d5_reset);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(),"d5");
            double[] input = new double[4];
            input[0] = Double.parseDouble(value1.getText().toString().trim());
            input[1] = Double.parseDouble(value2.getText().toString().trim());
            input[2] = Double.parseDouble(value3.getText().toString().trim());
            input[3] = Double.parseDouble(value4.getText().toString().trim());

            hideKeyboard(view);
            td.calculate(input);
            String result = td.getResult();
            answer.setText(result);
        }
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void reset(View view) {
        EditText value1 = findViewById(R.id.d5_e_user_input);
        EditText value2 = findViewById(R.id.d5_2c5_user_input);
        EditText value3 = findViewById(R.id.d5_2c5_2_user_input);
        EditText value4 = findViewById(R.id.d5_5c2_user_input);

        Button button = findViewById(R.id.d5_submit);
        TextView answerText = findViewById(R.id.d5_text);
        TextView answer = findViewById(R.id.d5_answer);
        Button reset = findViewById(R.id.d5_reset);

        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
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
