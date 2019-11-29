package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Nonaxial_Group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;

public class c1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1);
        TextView c1_descr = findViewById(R.id.c1_descr);
        c1_descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>1</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c1_e_user_input);
        Button button = findViewById(R.id.c1_submit);
        Button reset = findViewById(R.id.c1_reset);
        TextView answerText = findViewById(R.id.c1_text);
        TextView answer = findViewById(R.id.c1_answer);

        if (TextUtils.isEmpty(value1.getText().toString())) {
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else {
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answerText.setText(HtmlCompat.fromHtml("The reducible representation of C<sub>1</sub> reduces to: ", HtmlCompat.FROM_HTML_MODE_LEGACY));
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            String ans = value1.getText().toString() + "A";
            answer.setText(ans);
        }
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void reset(View view) {
        EditText value1 = findViewById(R.id.c1_e_user_input);
        Button button = findViewById(R.id.c1_submit);
        TextView answerText = findViewById(R.id.c1_text);
        TextView answer = findViewById(R.id.c1_answer);
        Button reset = findViewById(R.id.c1_reset);

        value1.setText("");
        button.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        reset.setVisibility(View.INVISIBLE);
    }
}