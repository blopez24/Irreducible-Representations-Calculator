package com.zybooks.irreduciblerepresentationscalculator.PointGroups;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;

public class d2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d2);
    }


    public void result(View view) {
        EditText value = findViewById(R.id.d2_e_user_input);
        EditText value2 = findViewById(R.id.d2_c2z_user_input);
        EditText value3 = findViewById(R.id.d2_c2y_user_input);
        EditText value4 = findViewById(R.id.d2_c2x_user_input);
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("value", value.getText());
        intent.putExtra("value2", value2.getText());
        intent.putExtra("value3", value3.getText());
        intent.putExtra("value4", value4.getText());
        startActivity(intent);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
