package com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.irreduciblerepresentationscalculator.MainActivity;
import com.zybooks.irreduciblerepresentationscalculator.R;
import com.zybooks.irreduciblerepresentationscalculator.Results;

public class d6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d6);
    }


    public void result(View view) {
        EditText value = findViewById(R.id.d6_e_user_input);
        EditText value2 = findViewById(R.id.d6_2c6_user_input);
        EditText value3 = findViewById(R.id.d6_2c3_user_input);
        EditText value4 = findViewById(R.id.d6_c2_user_input);
        EditText value5 = findViewById(R.id.d6_3c2_user_input);
        EditText value6 = findViewById(R.id.d6_3c2p_user_input);
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("value", value.getText());
        intent.putExtra("value2", value2.getText());
        intent.putExtra("value3", value3.getText());
        intent.putExtra("value4", value4.getText());
        intent.putExtra("value5", value5.getText());
        intent.putExtra("value6", value6.getText());
        startActivity(intent);
    }

    public void return_1(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
