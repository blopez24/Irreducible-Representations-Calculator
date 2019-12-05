package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Linear_Group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class dinfv extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinfv);

        TextView descr = findViewById(R.id.dinfh_descr);
        descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the D<sub>&#8734;h</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value = findViewById(R.id.dinfh_user_input);
        Button reset = findViewById(R.id.dinfh_reset);
        Button button = findViewById(R.id.dinfh_submit);
        TextView answerText = findViewById(R.id.dinfh_text);
        TextView answer = findViewById(R.id.dinfh_answer);

        if (TextUtils.isEmpty(value.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else {
            String StrValue= value.getText().toString();
            double realValue = Integer.parseInt(StrValue);
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            int floor = (int) Math.floor(realValue/2.0);
            int ceil = (int) Math.ceil(realValue/2.13);
            int e1gVib = floor - 1;
            int a1uVib = ceil - 1;
            int e1uVib = ceil - 1;

            String resultText1 = "Cartesian 3N:"; // +  + floor + "A<sub>1g</sub> + " + floor + "E<sub>1g</sub> + " +
            String resultText2 = floor+"A<sub>1g</sub> + " + floor + "E<sub>1g</sub> + " + ceil + "A<sub>1u</sub> + " + ceil + "E<sub>1u</sub>";
            String resultText3 = "Vibration:";
            String resultText4 = floor+"A<sub>1g</sub>";
            if(e1gVib > 0)
                resultText4 += " + " + e1gVib + "E<sub>1g</sub>";
            if(a1uVib > 0)
                resultText4 += " + " + a1uVib + "A<sub>1u</sub>";
            if(e1uVib > 0)
                resultText4 += " + " + e1uVib + "E<sub>1u</sub>";
            hideKeyboard(view);
            answer.setText(HtmlCompat.fromHtml(
                    resultText1+"<br/>"+resultText2+"<br/>"
                            +resultText3+"<br/>"+resultText4, HtmlCompat.FROM_HTML_MODE_LEGACY));
        }
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }

    public void reset(View view) {
        EditText value = findViewById(R.id.dinfh_user_input);

        Button reset = findViewById(R.id.dinfh_reset);
        Button button = findViewById(R.id.dinfh_submit);
        TextView answerText = findViewById(R.id.dinfh_text);
        TextView answer = findViewById(R.id.dinfh_answer);

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
