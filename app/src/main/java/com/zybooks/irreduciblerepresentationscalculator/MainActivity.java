package com.zybooks.irreduciblerepresentationscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTexts();
    }

    public void setTexts()
    {
        // TextView

        // Cn Groups
        TextView cn = findViewById(R.id.cn_group_text);
        cn.setText(HtmlCompat.fromHtml("C<sub>n</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cnv Groups
        TextView cnv = findViewById(R.id.cnv_group_text);
        cnv.setText(HtmlCompat.fromHtml("C<sub>nv</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cnh Groups
        TextView cnh = findViewById(R.id.cnh_group_text);
        cnh.setText(HtmlCompat.fromHtml("C<sub>nh</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dn Groups
        TextView dn = findViewById(R.id.dn_group_text);
        dn.setText(HtmlCompat.fromHtml("D<sub>n</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dnv Groups
        TextView dnv = findViewById(R.id.dnv_group_text);
        dnv.setText(HtmlCompat.fromHtml("D<sub>nv</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dnh Groups
        TextView dnh = findViewById(R.id.dnh_group_text);
        dnh.setText(HtmlCompat.fromHtml("D<sub>nh</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Buttons

        // Non-axial Groups
        Button c1 = findViewById(R.id.c1_button);
        c1.setText(HtmlCompat.fromHtml("C<sub>1</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button cs = findViewById(R.id.cs_button);
        cs.setText(HtmlCompat.fromHtml("C<sub>s</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button ci = findViewById(R.id.ci_button);
        ci.setText(HtmlCompat.fromHtml("C<sub>i</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cn Groups
        Button c2 = findViewById(R.id.c2);
        c2.setText(HtmlCompat.fromHtml("C<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c3 = findViewById(R.id.c3);
        c3.setText(HtmlCompat.fromHtml("C<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c4 = findViewById(R.id.c4);
        c4.setText(HtmlCompat.fromHtml("C<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c5 = findViewById(R.id.c5);
        c5.setText(HtmlCompat.fromHtml("C<sub>5</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c6 = findViewById(R.id.c6);
        c6.setText(HtmlCompat.fromHtml("C<sub>6</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cnv Groups
        Button c2v = findViewById(R.id.c2v);
        c2v.setText(HtmlCompat.fromHtml("C<sub>2v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c3v = findViewById(R.id.c3v);
        c3v.setText(HtmlCompat.fromHtml("C<sub>3v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c4v = findViewById(R.id.c4v);
        c4v.setText(HtmlCompat.fromHtml("C<sub>4v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c5v = findViewById(R.id.c5v);
        c5v.setText(HtmlCompat.fromHtml("C<sub>5v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c6v = findViewById(R.id.c6v);
        c6v.setText(HtmlCompat.fromHtml("C<sub>6v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cnh Groups
        Button c2h = findViewById(R.id.c2h);
        c2h.setText(HtmlCompat.fromHtml("C<sub>2h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c3h = findViewById(R.id.c3h);
        c3h.setText(HtmlCompat.fromHtml("C<sub>3h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c4h = findViewById(R.id.c4h);
        c4h.setText(HtmlCompat.fromHtml("C<sub>4h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c5h = findViewById(R.id.c5h);
        c5h.setText(HtmlCompat.fromHtml("C<sub>5h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button c6h = findViewById(R.id.c6h);
        c6h.setText(HtmlCompat.fromHtml("C<sub>6h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dn Groups
        Button d2 = findViewById(R.id.d2);
        d2.setText(HtmlCompat.fromHtml("D<sub>2</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d3 = findViewById(R.id.d3);
        d3.setText(HtmlCompat.fromHtml("D<sub>3</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d4 = findViewById(R.id.d4);
        d4.setText(HtmlCompat.fromHtml("D<sub>4</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d5 = findViewById(R.id.d5);
        d5.setText(HtmlCompat.fromHtml("D<sub>5</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d6 = findViewById(R.id.d6);
        d6.setText(HtmlCompat.fromHtml("D<sub>6</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dnv Groups
        Button d2v = findViewById(R.id.d2v);
        d2v.setText(HtmlCompat.fromHtml("D<sub>2v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d3v = findViewById(R.id.d3v);
        d3v.setText(HtmlCompat.fromHtml("D<sub>3v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d4v = findViewById(R.id.d4v);
        d4v.setText(HtmlCompat.fromHtml("D<sub>4v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d5v = findViewById(R.id.d5v);
        d5v.setText(HtmlCompat.fromHtml("D<sub>5v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d6v = findViewById(R.id.d6v);
        d6v.setText(HtmlCompat.fromHtml("D<sub>6v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Dnh Groups
        Button d2h = findViewById(R.id.d2h);
        d2h.setText(HtmlCompat.fromHtml("D<sub>2h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d3h = findViewById(R.id.d3h);
        d3h.setText(HtmlCompat.fromHtml("D<sub>3h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d4h = findViewById(R.id.d4h);
        d4h.setText(HtmlCompat.fromHtml("D<sub>4h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d5h = findViewById(R.id.d5h);
        d5h.setText(HtmlCompat.fromHtml("D<sub>5h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d6h = findViewById(R.id.d6h);
        d6h.setText(HtmlCompat.fromHtml("D<sub>6h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Cubic Groups
        Button td = findViewById(R.id.td);
        td.setText(HtmlCompat.fromHtml("T<sub>d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button o = findViewById(R.id.o);
        o.setText(HtmlCompat.fromHtml("O", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button oh = findViewById(R.id.oh);
        oh.setText(HtmlCompat.fromHtml("O<sub>h</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        // Linear Groups
        Button cinfv = findViewById(R.id.cinfv);
        cinfv.setText(HtmlCompat.fromHtml("C<sub>&#8734;v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button dinfv = findViewById(R.id.dinfv);
        dinfv.setText(HtmlCompat.fromHtml("D<sub>&#8734;v</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    public void c1(View view) {
        Intent intent = new Intent(this, Input.class);
        startActivity(intent);
    }

    public void cs(View view) {
    }

    public void ci(View view) {
    }

    public void c2(View view) {
    }

    public void c3(View view) {
    }

    public void c4(View view) {
    }

    public void c5(View view) {
    }

    public void c6(View view) {
    }

    public void c2v(View view) {
    }

    public void c3v(View view) {
    }

    public void c4v(View view) {
    }

    public void c5v(View view) {
    }

    public void c6v(View view) {
    }

    public void c2h(View view) {
    }

    public void c3h(View view) {
    }

    public void c4h(View view) {
    }

    public void c5h(View view) {
    }

    public void c6h(View view) {
    }

    public void d2(View view) {
    }

    public void d3(View view) {
    }

    public void d4(View view) {
    }

    public void d5(View view) {
    }

    public void d6(View view) {
    }

    public void d2v(View view) {
    }

    public void d3v(View view) {
    }

    public void d4v(View view) {
    }

    public void d5v(View view) {
    }

    public void d6v(View view) {
    }

    public void d2h(View view) {
    }

    public void d3h(View view) {
    }

    public void d4h(View view) {
    }

    public void d5h(View view) {
    }

    public void d6h(View view) {
    }

    public void td(View view) {
    }

    public void o(View view) {
    }

    public void oh(View view) {
    }

    public void cinfv(View view) {
    }

    public void dinfv(View view) {
    }
}
