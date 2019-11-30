package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group;

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

public class d3h extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d3h);

        TextView descr = findViewById(R.id.d3h_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the D<sub>3h</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView a = findViewById(R.id.d3h_2c3);
        a.setText(HtmlCompat.fromHtml("2C<sub>3</sub>(z)", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.d3h_3c2);
        b.setText(HtmlCompat.fromHtml("3C'<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.d3h_shxy);
        c.setText(HtmlCompat.fromHtml("&#963;<sub>h</sub>(xy)", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.d3h_2s3);
        d.setText(HtmlCompat.fromHtml("2S<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView e = findViewById(R.id.d3h_3sv);
        e.setText(HtmlCompat.fromHtml("3&#963;<sub>v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value0 = findViewById(R.id.d3h_e_user_input);
        EditText value1 = findViewById(R.id.d3h_2c3_user_input);
        EditText value2 = findViewById(R.id.d3h_3c2_user_input);
        EditText value3 = findViewById(R.id.d3h_shxy_user_input);
        EditText value4 = findViewById(R.id.d3h_2s3_user_input);
        EditText value5 = findViewById(R.id.d3h_3sv_user_input);

        Button reset = findViewById(R.id.d3h_reset);
        Button button = findViewById(R.id.d3h_submit);
        TextView answerText = findViewById(R.id.d3h_text);
        TextView answer = findViewById(R.id.d3h_answer);

        if (TextUtils.isEmpty(value0.getText().toString())
                || TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())
                || TextUtils.isEmpty(value5.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(),"d3h");
            int[] input = new int[6];
            input[0] = Integer.parseInt(value0.getText().toString().trim());
            input[1] = Integer.parseInt(value1.getText().toString().trim());
            input[2] = Integer.parseInt(value2.getText().toString().trim());
            input[3] = Integer.parseInt(value3.getText().toString().trim());
            input[4] = Integer.parseInt(value4.getText().toString().trim());
            input[5] = Integer.parseInt(value5.getText().toString().trim());

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
        EditText value0 = findViewById(R.id.d3h_e_user_input);
        EditText value1 = findViewById(R.id.d3h_2c3_user_input);
        EditText value2 = findViewById(R.id.d3h_3c2_user_input);
        EditText value3 = findViewById(R.id.d3h_shxy_user_input);
        EditText value4 = findViewById(R.id.d3h_2s3_user_input);
        EditText value5 = findViewById(R.id.d3h_3sv_user_input);

        Button reset = findViewById(R.id.d3h_reset);
        Button button = findViewById(R.id.d3h_submit);
        TextView answerText = findViewById(R.id.d3h_text);
        TextView answer = findViewById(R.id.d3h_answer);

        value0.setText("");
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

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

