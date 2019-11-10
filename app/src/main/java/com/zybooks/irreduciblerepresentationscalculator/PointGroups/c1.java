package com.zybooks.irreduciblerepresentationscalculator.PointGroups;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;

public class c1 extends AppCompatActivity {

    EditText value;
    Button button;
    TextView answerText, answer, step3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1);
    }


    public void result(View view) {
        value = findViewById(R.id.c1_e_user_input);
        button = findViewById(R.id.c1_submit);
        answerText = findViewById(R.id.c1_text);
        answer = findViewById(R.id.c1_answer);
        step3 = findViewById(R.id.c1_step3);

        step3.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        answerText.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);

        String ans = value.getText().toString() + "A";
        answer.setText(ans);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
