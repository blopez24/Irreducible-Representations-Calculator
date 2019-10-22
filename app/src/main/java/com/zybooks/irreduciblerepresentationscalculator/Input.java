package com.zybooks.irreduciblerepresentationscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Input extends AppCompatActivity {

    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_input);
    }


    public void result(View view) {
        value = findViewById(R.id.inputUser);
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("value", value.getText());
       // intent.putExtra("results", )
        startActivity(intent);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
