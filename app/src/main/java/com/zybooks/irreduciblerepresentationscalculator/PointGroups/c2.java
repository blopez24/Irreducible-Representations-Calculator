package com.zybooks.irreduciblerepresentationscalculator.PointGroups;

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
import com.zybooks.irreduciblerepresentationscalculator.TableData;

import org.w3c.dom.Text;

public class c2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2);
        TextView c2_descr = findViewById(R.id.c2_descr);
        c2_descr.setText(HtmlCompat.fromHtml(
                "Enter the characters for the reducible representation of the C<sub>2</sub> point group below.", HtmlCompat.FROM_HTML_MODE_LEGACY));
        TextView c2_c2 = findViewById(R.id.c2_c2);
        c2_c2.setText(HtmlCompat.fromHtml("C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void result(View view) {
        EditText value1 = findViewById(R.id.c2_e_user_input);
        EditText value2 = findViewById(R.id.c2_c2_user_input);
        Button button = findViewById(R.id.c2_submit);
        TextView answerText = findViewById(R.id.c2_text);
        TextView answer = findViewById(R.id.c2_answer);
        Button reset = findViewById(R.id.c2_reset);


        if (TextUtils.isEmpty(value1.getText().toString())
                || TextUtils.isEmpty(value2.getText().toString())){
            Toast.makeText(this,"Please enter the values for each cell!", Toast.LENGTH_LONG).show();
        } else{
            button.setVisibility(View.GONE);
            answerText.setVisibility(View.VISIBLE);
            answer.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);

            TableData td = new TableData(getApplicationContext(), "c2");
            int[] input = new int[2];
            input[0] = Integer.parseInt(value1.getText().toString().trim());
            input[1] = Integer.parseInt(value2.getText().toString().trim());

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
        EditText value1 = findViewById(R.id.c2_e_user_input);
        EditText value2 = findViewById(R.id.c2_c2_user_input);
        Button button = findViewById(R.id.c2_submit);
        TextView answerText = findViewById(R.id.c2_text);
        TextView answer = findViewById(R.id.c2_answer);
        Button reset = findViewById(R.id.c2_reset);

        value1.setText("");
        value2.setText("");
        button.setVisibility(View.VISIBLE);
        answerText.setVisibility(View.GONE);
        answer.setVisibility(View.GONE);
        reset.setVisibility(View.INVISIBLE);
    }
}
