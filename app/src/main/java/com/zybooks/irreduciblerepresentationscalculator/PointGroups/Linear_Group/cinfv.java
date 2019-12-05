package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Linear_Group;

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

public class cinfv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cinfv);

        TextView descr = findViewById(R.id.cinfv_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>&#8734;v</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value = findViewById(R.id.cinfv_user_input);

        Button reset = findViewById(R.id.cinfv_reset);
        Button button = findViewById(R.id.cinfv_submit);
        TextView answerText = findViewById(R.id.cinfv_text);
        TextView answer = findViewById(R.id.cinfv_answer);

        if (TextUtils.isEmpty(value.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else {
            String StrValue= value.getText().toString();
            int realValue = Integer.parseInt(StrValue);
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            hideKeyboard(view);
            String resultText = "Cartesian 3N:<br/>" + realValue + "A<sub>1</sub> + " + realValue + "E<sub>1</sub><br/>Vibration:<br/>";
            if (realValue == 2)
                resultText += "\n\n" + (realValue - 1) + "A<sub>1</sub>";
            else
                resultText += "\n\n" + (realValue - 1) + "A<sub>1</sub> + " + (realValue - 2) + "E<sub>1</sub>";
            answer.setText(HtmlCompat.fromHtml(
                    resultText, HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void reset(View view) {
        EditText value = findViewById(R.id.cinfv_user_input);

        Button reset = findViewById(R.id.cinfv_reset);
        Button button = findViewById(R.id.cinfv_submit);
        TextView answerText = findViewById(R.id.cinfv_text);
        TextView answer = findViewById(R.id.cinfv_answer);

        value.setText("");
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
