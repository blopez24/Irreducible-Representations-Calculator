package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cubic_Group;
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

public class oh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oh);

        TextView descr = findViewById(R.id.oh_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the O<sub>h</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));

        TextView a = findViewById(R.id.oh_8c3);
        a.setText(HtmlCompat.fromHtml("8C<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView b = findViewById(R.id.oh_6c2);
        b.setText(HtmlCompat.fromHtml("6C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c = findViewById(R.id.oh_6c4);
        c.setText(HtmlCompat.fromHtml("6C<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView d = findViewById(R.id.oh_c42);
        d.setText(HtmlCompat.fromHtml("(C<sub>4</sub>)<sup>2</sup>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView e = findViewById(R.id.oh_6s4);
        e.setText(HtmlCompat.fromHtml("6S<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView f = findViewById(R.id.oh_8s6);
        f.setText(HtmlCompat.fromHtml("8S<sub>6</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.oh_e_user_input);
        EditText value2 = findViewById(R.id.oh_8c3_user_input);
        EditText value3 = findViewById(R.id.oh_6c2_user_input);
        EditText value4 = findViewById(R.id.oh_6c4_user_input);
        EditText value5 = findViewById(R.id.oh_c42_user_input);
        EditText value6 = findViewById(R.id.oh_i_user_input);
        EditText value7 = findViewById(R.id.oh_6s4_user_input);
        EditText value8 = findViewById(R.id.oh_8s6_user_input);
        EditText value9 = findViewById(R.id.oh_3sh_user_input);
        EditText value10 = findViewById(R.id.oh_6sd_user_input);

        Button button = findViewById(R.id.oh_submit);
        TextView answerText = findViewById(R.id.oh_text);
        TextView answer = findViewById(R.id.oh_answer);
        Button reset = findViewById(R.id.oh_reset);

        hideKeyboard(view);

        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())
                || TextUtils.isEmpty(value3.getText().toString())
                || TextUtils.isEmpty(value4.getText().toString())
                || TextUtils.isEmpty(value5.getText().toString())
                || TextUtils.isEmpty(value6.getText().toString())
                || TextUtils.isEmpty(value7.getText().toString())
                || TextUtils.isEmpty(value8.getText().toString())
                || TextUtils.isEmpty(value9.getText().toString())
                || TextUtils.isEmpty(value10.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(), "oh");
            int[] input = new int[10];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());
            input[2] = Integer.parseInt(value3.getText().toString().trim());
            input[3] = Integer.parseInt(value4.getText().toString().trim());
            input[4] = Integer.parseInt(value5.getText().toString().trim());
            input[5] = Integer.parseInt(value6.getText().toString().trim());
            input[6] = Integer.parseInt(value7.getText().toString().trim());
            input[7] = Integer.parseInt(value8.getText().toString().trim());
            input[8] = Integer.parseInt(value9.getText().toString().trim());
            input[9] = Integer.parseInt(value10.getText().toString().trim());

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
        EditText value1 = findViewById(R.id.oh_e_user_input);
        EditText value2 = findViewById(R.id.oh_8c3_user_input);
        EditText value3 = findViewById(R.id.oh_6c2_user_input);
        EditText value4 = findViewById(R.id.oh_6c4_user_input);
        EditText value5 = findViewById(R.id.oh_c42_user_input);
        EditText value6 = findViewById(R.id.oh_i_user_input);
        EditText value7 = findViewById(R.id.oh_6s4_user_input);
        EditText value8 = findViewById(R.id.oh_8s6_user_input);
        EditText value9 = findViewById(R.id.oh_3sh_user_input);
        EditText value10 = findViewById(R.id.oh_6sd_user_input);

        Button button = findViewById(R.id.oh_submit);
        TextView answerText = findViewById(R.id.oh_text);
        TextView answer = findViewById(R.id.oh_answer);
        Button reset = findViewById(R.id.oh_reset);

        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        value6.setText("");
        value7.setText("");
        value8.setText("");
        value9.setText("");
        value10.setText("");
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

