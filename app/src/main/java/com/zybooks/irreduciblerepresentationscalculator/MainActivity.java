package com.zybooks.irreduciblerepresentationscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Nonaxial_Group.c1;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group.c2;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group.c2h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group.c2v;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group.c3;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group.c3h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group.c3v;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group.c4;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group.c4h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group.c4v;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group.c5;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group.c5v;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cn_Group.c6;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnv_Group.c6v;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Nonaxial_Group.ci;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Linear_Group.cinfv;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Nonaxial_Group.cs;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group.d2;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group.d2d;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group.d2h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group.d3;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group.d3d;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group.d4;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group.d4d;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group.d5;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group.d5d;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dn_Group.d6;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnd_Group.d6d;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cubic_Group.o;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cubic_Group.td;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        // Dnd Groups
        TextView dnd = findViewById(R.id.dnd_group_text);
        dnd.setText(HtmlCompat.fromHtml("D<sub>nd</sub> Groups", HtmlCompat.FROM_HTML_MODE_LEGACY));

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

        // Dnd Groups
        Button d2d = findViewById(R.id.d2d);
        d2d.setText(HtmlCompat.fromHtml("D<sub>2d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d3d = findViewById(R.id.d3d);
        d3d.setText(HtmlCompat.fromHtml("D<sub>3d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d4d = findViewById(R.id.d4d);
        d4d.setText(HtmlCompat.fromHtml("D<sub>4d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d5d = findViewById(R.id.d5d);
        d5d.setText(HtmlCompat.fromHtml("D<sub>5d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

        Button d6d = findViewById(R.id.d6d);
        d6d.setText(HtmlCompat.fromHtml("D<sub>6d</sub>", HtmlCompat.FROM_HTML_MODE_LEGACY));

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
        Intent intent = new Intent(this, c1.class);
        startActivity(intent);
    }

    public void cs(View view) {
        Intent intent = new Intent(this, cs.class);
        startActivity(intent);
    }

    public void ci(View view) {
        Intent intent = new Intent(this, ci.class);
        startActivity(intent);
    }

    public void c2(View view) {
        Intent intent = new Intent(this, c2.class);
        startActivity(intent);
    }

    public void c3(View view) {
        Intent intent = new Intent(this, c3.class);
        startActivity(intent);
    }

    public void c4(View view) {
        Intent intent = new Intent(this, c4.class);
        startActivity(intent);
    }

    public void c5(View view) {
        Intent intent = new Intent(this, c5.class);
        startActivity(intent);
    }

    public void c6(View view) {
        Intent intent = new Intent(this, c6.class);
        startActivity(intent);
    }

    public void c2v(View view) {
        Intent intent = new Intent(this, c2v.class);
        startActivity(intent);
    }

    public void c3v(View view) {
        Intent it = new Intent(this, c3v.class);
        startActivity(it);
    }

    public void c4v(View view) {
        Intent it = new Intent(this, c4v.class);
        startActivity(it);
    }

    public void c5v(View view) {
        Intent it = new Intent(this, c5v.class);
        startActivity(it);
    }

    public void c6v(View view) {
        Intent it = new Intent(this, c6v.class);
        startActivity(it);
    }

    public void c2h(View view) {
        Intent it = new Intent(this, c2h.class);
        startActivity(it);
    }

    public void c3h(View view) {
        Intent it = new Intent(this, c3h.class);
        startActivity(it);
    }

    public void c4h(View view) {////////////////////////////////////////////////////
        Intent it = new Intent(this, c4h.class);
        startActivity(it);
    }

    public void c5h(View view) {///////////////////////////////////////////////////

    }

    public void c6h(View view) {///////////////////////////////////////////////////////

    }

    public void d2(View view) {
        Intent it = new Intent(this, d2.class);
        startActivity(it);
    }

    public void d3(View view) {
        Intent it = new Intent(this, d3.class);
        startActivity(it);
    }

    public void d4(View view) {
        Intent it = new Intent(this, d4.class);
        startActivity(it);
    }

    public void d5(View view) {
        Intent it = new Intent(this, d5.class);
        startActivity(it);
    }

    public void d6(View view) {
        Intent it = new Intent(this, d6.class);
        startActivity(it);
    }

    public void d2d(View view) {
        Intent it = new Intent(this, d2d.class);
        startActivity(it);
    }

    public void d3d(View view) {
        Intent it = new Intent(this, d3d.class);
        startActivity(it);
    }

    public void d4d(View view) { ///////////////////////////////////////////////
        Intent it = new Intent(this, d4d.class);
        startActivity(it);
    }

    public void d5d(View view) {/////////////////////////////////////////////////////
        Intent it = new Intent(this, d5d.class);
        startActivity(it);
    }

    public void d6d(View view) {/////////////////////////////////////////////
        Intent it = new Intent(this, d6d.class);
        startActivity(it);
    }

    public void d2h(View view){
        Intent it = new Intent(this, d2h.class);
        startActivity(it);
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
        Intent it = new Intent(this, td.class);
        startActivity(it);
    }

    public void o(View view) {
        Intent it = new Intent(this, o.class);
        startActivity(it);
    }

    public void oh(View view) {
    }

    public void cinfv(View view) {
        Intent it = new Intent(this, cinfv.class);
        startActivity(it);
    }

    public void dinfv(View view) {
    }
}
