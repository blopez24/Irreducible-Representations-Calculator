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

public class c2 extends AppCompatActivity {

    EditText value;
    EditText value2;
    Button button;
    TextView answerText, answer, step3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2);
    }


    public void result(View view) {
        value = findViewById(R.id.c2_e_user_input);
        value2 = findViewById(R.id.c2_c2_user_input);
        button = findViewById(R.id.c2_submit);
        answerText = findViewById(R.id.c2_text);
        answer = findViewById(R.id.c2_answer);
        step3 = findViewById(R.id.c2_step3);

        step3.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        answerText.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        answer.setText("2A + 3B");
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
