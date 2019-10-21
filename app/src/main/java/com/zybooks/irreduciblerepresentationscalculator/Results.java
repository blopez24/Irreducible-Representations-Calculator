package com.zybooks.irreduciblerepresentationscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Results extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        text = findViewById(R.id.cell);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        text.setText(bundle.get("value").toString());

    }
}
