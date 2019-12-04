package com.zybooks.irreduciblerepresentationscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group.c5h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cnh_Group.c6h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Cubic_Group.oh;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group.d3h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group.d4h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group.d5h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Dnh_Group.d6h;
import com.zybooks.irreduciblerepresentationscalculator.PointGroups.Linear_Group.dinfv;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner pointList = findViewById(R.id.spinner);
        final LinearLayout tableLayout = findViewById(R.id.table);
        final Spinner nonaxial = findViewById(R.id.nonaxial);
        final Spinner cn = findViewById(R.id.cn);
        final Spinner cnv = findViewById(R.id.cnv);
        final Spinner cnh = findViewById(R.id.cnh);
        final Spinner dn = findViewById(R.id.dn);
        final Spinner dnd = findViewById(R.id.dnd);
        final Spinner dnh = findViewById(R.id.dnh);
        final Spinner cubic = findViewById(R.id.cubic);
        final Spinner linear = findViewById(R.id.linear);
        RadioGroup radioGroup = findViewById(R.id.RadioGr);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_dropdown){
                    pointList.setVisibility(View.VISIBLE);
                    tableLayout.setVisibility(View.GONE);

                    pointList.setSelection(0);
                    cn.setVisibility(View.GONE);
                    nonaxial.setVisibility(View.GONE);
                    cnv.setVisibility(View.GONE);
                    cnh.setVisibility(View.GONE);
                    dn.setVisibility(View.GONE);
                    dnd.setVisibility(View.GONE);
                    dnh.setVisibility(View.GONE);
                    cubic.setVisibility(View.GONE);
                    linear.setVisibility(View.GONE);
                } else if (checkedId == R.id.radio_table){
                    pointList.setVisibility(View.GONE);
                    tableLayout.setVisibility(View.VISIBLE);

                    cn.setVisibility(View.GONE);
                    nonaxial.setVisibility(View.GONE);
                    cnv.setVisibility(View.GONE);
                    cnh.setVisibility(View.GONE);
                    dn.setVisibility(View.GONE);
                    dnd.setVisibility(View.GONE);
                    dnh.setVisibility(View.GONE);
                    cubic.setVisibility(View.GONE);
                    linear.setVisibility(View.GONE);
                }
            }
        });

        setTexts();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.point_name, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        pointList.setAdapter(adapter);
        pointList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("main", "position: " + position);
                linear.setVisibility(View.GONE);
                cn.setVisibility(View.GONE);
                nonaxial.setVisibility(View.GONE);
                cnv.setVisibility(View.GONE);
                cnh.setVisibility(View.GONE);
                dn.setVisibility(View.GONE);
                dnd.setVisibility(View.GONE);
                dnh.setVisibility(View.GONE);
                cubic.setVisibility(View.GONE);
                switch (position){
                    case 1: // nonaxial group
                        ArrayAdapter na_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.nonaxial, R.layout.spinner_item);
                        na_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        nonaxial.setAdapter(na_adapter);
                        nonaxial.setVisibility(View.VISIBLE);
                        nonaxial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //c1
                                        Intent intent = new Intent(MainActivity.this, c1.class);
                                        startActivity(intent);
                                        break;
                                    case 2: //cs
                                        Intent intent2 = new Intent(MainActivity.this, cs.class);
                                        startActivity(intent2);
                                        break;
                                    case 3: //ci
                                        Intent intent3 = new Intent(MainActivity.this, ci.class);
                                        startActivity(intent3);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of nonaxial group =========

                    case 2: //cn
                        ArrayAdapter cn_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.cn, R.layout.spinner_item);
                        cn_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        cn.setAdapter(cn_adapter);
                        cn.setVisibility(View.VISIBLE);
                        cn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //c2
                                        Intent it = new Intent(MainActivity.this, c2.class);
                                        startActivity(it);
                                        break;
                                    case 2: //c3
                                        Intent it2 = new Intent(MainActivity.this, c3.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //c4
                                        Intent it3 = new Intent(MainActivity.this, c4.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //c5
                                        Intent it4 = new Intent(MainActivity.this, c5.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //c6
                                        Intent it5 = new Intent(MainActivity.this, c6.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of cn group =====================

                    case 3: // cnv
                        ArrayAdapter cnv_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.cnv, R.layout.spinner_item);
                        cnv_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        cnv.setAdapter(cnv_adapter);
                        cnv.setVisibility(View.VISIBLE);
                        cnv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //c2v
                                        Intent it = new Intent(MainActivity.this, c2v.class);
                                        startActivity(it);
                                        break;
                                    case 2: //c3v
                                        Intent it2 = new Intent(MainActivity.this, c3v.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //c4v
                                        Intent it3 = new Intent(MainActivity.this, c4v.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //c5v
                                        Intent it4 = new Intent(MainActivity.this, c5v.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //c6v
                                        Intent it5 = new Intent(MainActivity.this, c6v.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of cnv group ============================

                    case 4: // cnh
                        ArrayAdapter cnh_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.cnh, R.layout.spinner_item);
                        cnh_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        cnh.setAdapter(cnh_adapter);
                        cnh.setVisibility(View.VISIBLE);
                        cnh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //c2h
                                        Intent it = new Intent(MainActivity.this, c2h.class);
                                        startActivity(it);
                                        break;
                                    case 2: //c3h
                                        Intent it2 = new Intent(MainActivity.this, c3h.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //c4h
                                        Intent it3 = new Intent(MainActivity.this, c4h.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //c5h
                                        Intent it4 = new Intent(MainActivity.this, c5h.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //c6h
                                        Intent it5 = new Intent(MainActivity.this, c6h.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of cnh group ========================

                    case 5: // dn
                        ArrayAdapter dn_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Dn, R.layout.spinner_item);
                        dn_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        dn.setAdapter(dn_adapter);
                        dn.setVisibility(View.VISIBLE);
                        dn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //d2
                                        Intent it = new Intent(MainActivity.this, d2.class);
                                        startActivity(it);
                                        break;
                                    case 2: //d3
                                        Intent it2 = new Intent(MainActivity.this, d3.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //d4
                                        Intent it3 = new Intent(MainActivity.this, d4.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //d5
                                        Intent it4 = new Intent(MainActivity.this, d5.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //d6
                                        Intent it5 = new Intent(MainActivity.this, d6.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of dn group =================================

                    case 6:
                        ArrayAdapter dnd_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Dnd, R.layout.spinner_item);
                        dnd_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        dnd.setAdapter(dnd_adapter);
                        dnd.setVisibility(View.VISIBLE);
                        dnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //d2d
                                        Intent it = new Intent(MainActivity.this, d2d.class);
                                        startActivity(it);
                                        break;
                                    case 2: //d3d
                                        Intent it2 = new Intent(MainActivity.this, d3d.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //d4d
                                        Intent it3 = new Intent(MainActivity.this, d4d.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //d5d
                                        Intent it4 = new Intent(MainActivity.this, d5d.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //d6d
                                        Intent it5 = new Intent(MainActivity.this, d6d.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of dnd group ================================

                    case 7: //dnh
                        ArrayAdapter dnh_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.Dnh, R.layout.spinner_item);
                        dnh_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        dnh.setAdapter(dnh_adapter);
                        dnh.setVisibility(View.VISIBLE);
                        dnh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //d2h
                                        Intent it = new Intent(MainActivity.this, d2h.class);
                                        startActivity(it);
                                        break;
                                    case 2: //d3h
                                        Intent it2 = new Intent(MainActivity.this, d3h.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //d4h
                                        Intent it3 = new Intent(MainActivity.this, d4h.class);
                                        startActivity(it3);
                                        break;
                                    case 4: //d5h
                                        Intent it4 = new Intent(MainActivity.this, d5h.class);
                                        startActivity(it4);
                                        break;
                                    case 5: //d6h
                                        Intent it5 = new Intent(MainActivity.this, d6h.class);
                                        startActivity(it5);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of dnh group ============================

                    case 8: //cubic
                        ArrayAdapter cubic_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.cubic, R.layout.spinner_item);
                        cubic_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        cubic.setAdapter(cubic_adapter);
                        cubic.setVisibility(View.VISIBLE);
                        cubic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //td
                                        Intent it = new Intent(MainActivity.this, td.class);
                                        startActivity(it);
                                        break;
                                    case 2: //o
                                        Intent it2 = new Intent(MainActivity.this, o.class);
                                        startActivity(it2);
                                        break;
                                    case 3: //oh
                                        Intent it3 = new Intent(MainActivity.this, oh.class);
                                        startActivity(it3);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of cubic group ================================

                    case 9: //linear
                        ArrayAdapter linear_adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.linear, R.layout.spinner_item);
                        linear_adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                        linear.setAdapter(linear_adapter);
                        linear.setVisibility(View.VISIBLE);
                        linear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 1: //cinfv
                                        Intent it = new Intent(MainActivity.this, cinfv.class);
                                        startActivity(it);
                                        break;
                                    case 2: //dinfh
                                        Intent it2 = new Intent(MainActivity.this, dinfv.class);
                                        startActivity(it2);
                                        break;
                                    default:
                                }
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                        break;
                    // end of linear group ==================================

                    default: // whenever "SELECT A POINT GROUP" is selected
                        linear.setVisibility(View.GONE);
                        cn.setVisibility(View.GONE);
                        nonaxial.setVisibility(View.GONE);
                        cnv.setVisibility(View.GONE);
                        cnh.setVisibility(View.GONE);
                        dn.setVisibility(View.GONE);
                        dnd.setVisibility(View.GONE);
                        dnh.setVisibility(View.GONE);
                        cubic.setVisibility(View.GONE);
                        break;
                }// end of switch for main spinner dropdown menu
            } // end of onItemSelected for main spinner dropdown menu

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        }); // end of onItemSelectedListener
    } //end of onCreate


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

    public void c4h(View view) {
        Intent it = new Intent(this, c4h.class);
        startActivity(it);
    }

    public void c5h(View view) {
        Intent it = new Intent(this, c5h.class);
        startActivity(it);
    }

    public void c6h(View view) {
        Intent it = new Intent(this, c6h.class);
        startActivity(it);
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

    public void d4d(View view) {
        Intent it = new Intent(this, d4d.class);
        startActivity(it);
    }

    public void d5d(View view) {
        Intent it = new Intent(this, d5d.class);
        startActivity(it);
    }

    public void d6d(View view) {
        Intent it = new Intent(this, d6d.class);
        startActivity(it);
    }

    public void d2h(View view){
        Intent it = new Intent(this, d2h.class);
        startActivity(it);
    }

    public void d3h(View view) {
        Intent it = new Intent(this, d3h.class);
        startActivity(it);
    }

    public void d4h(View view) {
        Intent it = new Intent(this, d4h.class);
        startActivity(it);
    }

    public void d5h(View view) {
        Intent it = new Intent(this, d5h.class);
        startActivity(it);
    }

    public void d6h(View view) {
        Intent it = new Intent(this, d6h.class);
        startActivity(it);
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
        Intent it = new Intent(this, oh.class);
        startActivity(it);
    }

    public void cinfv(View view) {
        Intent it = new Intent(this, cinfv.class);
        startActivity(it);
    }

    public void dinfv(View view) {
        Intent it = new Intent(this, dinfv.class);
        startActivity(it);
    }


    public void show_dropdown(View view) {
    }

    public void show_table(View view) {
    }
}
