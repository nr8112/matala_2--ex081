package com.example.matala_2__ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class hishov_sdra extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    TextView x1, dOrB, n, pos;
    String s;

    // arry
    String[] num_ListView = new String[20];
    Float[] sum_A = new Float[20];

    float a, b, f, num, sum = 0;

    int yes, y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hishov_sdra);

        lv = findViewById(R.id.lv);
        x1 = findViewById(R.id.x1);
        dOrB = findViewById(R.id.d);
        n = findViewById(R.id.n);
        pos = findViewById(R.id.sn);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        start(); //bring everything from the main

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, num_ListView);
        lv.setAdapter(adp);
        hisov_urahim(sum_A, num_ListView);

    }

    private void start() {

        Intent gi = getIntent();
        yes = gi.getIntExtra("Switch_yes_no", 1);
        a = gi.getFloatExtra("AddsOrMultiplies", 1);
        b = gi.getFloatExtra("startNum", 1);
        num = b;


        x1.setText("" + b);

        dOrB.setText("" + a);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        y = position + 1;
        n.setText("" + y);
        pos.setText("" + sum_A[position]);
    }

    public void finish(View view) {
        finish();
    }


    public void hisov_urahim(Float[] sum_A, String[]num_ListView) {

        if (yes == 1) {
            for (int i = 0; i < 20; i++) {
                if (i == 0) {

                    f = num;
                    sum = num;
                } else {
                    f = num + a;
                    sum = sum + f;
                }

                sum_A[i] = sum;
                s = Float.toString(f);
                num_ListView[i] = s;
                num = Float.parseFloat(num_ListView[i]);
            }
        }
        if (yes == 2) {
            for (int i = 0; i < 20; i++) {
                if (i == 0) {
                    f = num;
                    sum = num;
                } else {
                    f = num * a;
                    sum = sum + f;
                }

                sum_A[i] = sum;
                s = Float.toString(f);
                num_ListView[i] = s;
                num = Float.parseFloat(num_ListView[i]);
            }

        }

    }
}
