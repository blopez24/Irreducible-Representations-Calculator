package com.zybooks.irreduciblerepresentationscalculator.PointGroups;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;

public class cs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cs);
    }


    public void result(View view) {
        EditText value1 = findViewById(R.id.cs_e_user_input);
        EditText value2 = findViewById(R.id.cs_sh_user_input);
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("value", value1.getText());
        intent.putExtra("value2", value2.getText());
        startActivity(intent);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
