package com.zybooks.irreduciblerepresentationscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

public class Results extends AppCompatActivity {

    TextView text;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        text = findViewById(R.id.cell);
        resultView = findViewById(R.id.result_view);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        text.setText(bundle.get("value").toString());
        resultView.setText(bundle.get("value").toString());
    }

    public void return_2(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }

    public void return_same_button(View view) {
        Intent it = new Intent(this, Input.class);
        startActivity(it);
    }

}
