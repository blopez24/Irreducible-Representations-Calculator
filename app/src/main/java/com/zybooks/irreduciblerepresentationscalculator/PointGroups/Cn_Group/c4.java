package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group;

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

public class c4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c4);

        TextView c4_descr = findViewById(R.id.c4_descr);
        c4_descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>4</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView a = findViewById(R.id.c4_2c4);
        a.setText(HtmlCompat.fromHtml("2C<sub>4</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.c4_c2);
        b.setText(HtmlCompat.fromHtml("C<sub>2</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c4_e_user_input);
        EditText value2 = findViewById(R.id.c4_2c4_user_input);
        EditText value3 = findViewById(R.id.c4_c2_user_input);

        Button button = findViewById(R.id.c4_submit);
        TextView answerText = findViewById(R.id.c4_text);
        TextView answer = findViewById(R.id.c4_answer);
        Button reset = findViewById(R.id.c4_reset);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(), "c4");
            double[] input = new double[3];
            input[0] = Double.parseDouble(value1.getText().toString().trim());
            input[1] = Double.parseDouble(value2.getText().toString().trim());
            input[2] = Double.parseDouble(value3.getText().toString().trim());

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
        EditText value1 = findViewById(R.id.c4_e_user_input);
        EditText value2 = findViewById(R.id.c4_2c4_user_input);
        EditText value3 = findViewById(R.id.c4_c2_user_input);

        Button button = findViewById(R.id.c4_submit);
        TextView answerText = findViewById(R.id.c4_text);
        TextView answer = findViewById(R.id.c4_answer);
        Button reset = findViewById(R.id.c4_reset);

        value1.setText("");
        value2.setText("");
        value3.setText("");
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
