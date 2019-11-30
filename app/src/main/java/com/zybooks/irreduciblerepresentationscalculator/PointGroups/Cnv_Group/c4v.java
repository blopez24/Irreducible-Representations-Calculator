package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group;

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

public class c4v extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c4v);

        TextView c4v_descr = findViewById(R.id.c4v_descr);
        c4v_descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>4v</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView a = findViewById(R.id.c4v_2c4);
        a.setText(HtmlCompat.fromHtml("2C<sub>4</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.c4v_c2);
        b.setText(HtmlCompat.fromHtml("C<sub>2</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.c4v_2sv);
        c.setText(HtmlCompat.fromHtml("2&#963;<sub>v</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.c4v_2sd);
        d.setText(HtmlCompat.fromHtml("2&#963;<sub>d</sub>",HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c4v_e_user_input);
        EditText value2 = findViewById(R.id.c4v_2c4_user_input);
        EditText value3 = findViewById(R.id.c4v_c2_user_input);
        EditText value4 = findViewById(R.id.c4v_2Sv_user_input);
        EditText value5 = findViewById(R.id.c4v_2Sd_user_input);

        Button button = findViewById(R.id.c4v_submit);
        TextView answerText = findViewById(R.id.c4v_text);
        TextView answer = findViewById(R.id.c4v_answer);
        Button reset = findViewById(R.id.c4v_reset);

        if (TextUtils.isEmpty(value1.getText().toString())
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

            TableData td = new TableData(getApplicationContext(), "c4v");
            int[] input = new int[5];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());
            input[2] = Integer.parseInt(value3.getText().toString().trim());
            input[3] = Integer.parseInt(value4.getText().toString().trim());
            input[4] = Integer.parseInt(value5.getText().toString().trim());

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
        EditText value1 = findViewById(R.id.c4v_e_user_input);
        EditText value2 = findViewById(R.id.c4v_2c4_user_input);
        EditText value3 = findViewById(R.id.c4v_c2_user_input);
        EditText value4 = findViewById(R.id.c4v_2Sv_user_input);
        EditText value5 = findViewById(R.id.c4v_2Sd_user_input);

        Button button = findViewById(R.id.c4v_submit);
        TextView answerText = findViewById(R.id.c4v_text);
        TextView answer = findViewById(R.id.c4v_answer);
        Button reset = findViewById(R.id.c4v_reset);

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
