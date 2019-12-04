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
import com.zybooks.irreduciblerepresentationscalculator.TableData;

public class c6h extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c6h);

        TextView descr = findViewById(R.id.c6h_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>6h</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView a = findViewById(R.id.c6h_2c6);
        a.setText(HtmlCompat.fromHtml("2C<sub>6</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.c6h_2c3);
        b.setText(HtmlCompat.fromHtml("2C<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.c6h_c2);
        c.setText(HtmlCompat.fromHtml("C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView h = findViewById(R.id.c6h_2s6);
        h.setText(HtmlCompat.fromHtml("2S<sub>6</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView i = findViewById(R.id.c6h_2s3);
        i.setText(HtmlCompat.fromHtml("2S<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView j = findViewById(R.id.c6h_sh);
        j.setText(HtmlCompat.fromHtml("&#963;<sub>h</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c6h_e_user_input);
        EditText value2 = findViewById(R.id.c6h_2c6_user_input);
        EditText value3 = findViewById(R.id.c6h_2c3_user_input);
        EditText value4 = findViewById(R.id.c6h_c2_user_input);
        EditText value5 = findViewById(R.id.c6h_i_user_input);
        EditText value6 = findViewById(R.id.c6h_2s6_user_input);
        EditText value7 = findViewById(R.id.c6h_2s3_user_input);
        EditText value8 = findViewById(R.id.c6h_sh_user_input);

        Button button = findViewById(R.id.c6h_submit);
        TextView answerText = findViewById(R.id.c6h_text);
        TextView answer = findViewById(R.id.c6h_answer);
        Button reset = findViewById(R.id.c6h_reset);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())
                || TextUtils.isEmpty(value5.getText().toString())
                || TextUtils.isEmpty(value6.getText().toString())
                || TextUtils.isEmpty(value7.getText().toString())
                || TextUtils.isEmpty(value8.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(), "c6h");
            int[] input = new int[8];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());
            input[2] = Integer.parseInt(value3.getText().toString().trim());
            input[3] = Integer.parseInt(value4.getText().toString().trim());
            input[4] = Integer.parseInt(value5.getText().toString().trim());
            input[5] = Integer.parseInt(value6.getText().toString().trim());
            input[6] = Integer.parseInt(value7.getText().toString().trim());
            input[7] = Integer.parseInt(value8.getText().toString().trim());

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
        EditText value1 = findViewById(R.id.c6h_e_user_input);
        EditText value2 = findViewById(R.id.c6h_2c6_user_input);
        EditText value3 = findViewById(R.id.c6h_2c3_user_input);
        EditText value4 = findViewById(R.id.c6h_c2_user_input);
        EditText value5 = findViewById(R.id.c6h_i_user_input);
        EditText value6 = findViewById(R.id.c6h_2s6_user_input);
        EditText value7 = findViewById(R.id.c6h_2s3_user_input);
        EditText value8 = findViewById(R.id.c6h_sh_user_input);

        Button button = findViewById(R.id.c6h_submit);
        TextView answerText = findViewById(R.id.c6h_text);
        TextView answer = findViewById(R.id.c6h_answer);
        Button reset = findViewById(R.id.c6h_reset);

        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        value6.setText("");
        value7.setText("");
        value8.setText("");
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
