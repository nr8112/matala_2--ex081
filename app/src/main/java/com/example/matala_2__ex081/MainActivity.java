package com.example.matala_2__ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ED_AddsOrMultiplies, ED_startNum;
    String dom, sn; // dom=Adds+Or+Multiplies sn=start +Num
    float a, b;
    int x;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ED_AddsOrMultiplies = findViewById(R.id.ed1);
        ED_startNum = findViewById(R.id.ed2);
        sw = findViewById(R.id.sw);
    }

    public void calculat(View view) {

        dom = ED_AddsOrMultiplies.getText().toString();
        sn = ED_startNum.getText().toString();

        if (dom.isEmpty() || sn.isEmpty()) { Toast.makeText(this, "Check if  you have filled in all the fields", Toast.LENGTH_SHORT).show();}// if all the fields full if not Send an alert

        else {
            //Checking the switch
            if (sw.isChecked())
                x = 1;

            else x = 2;
            a = Float.parseFloat(dom);
            b = Float.parseFloat(sn);

            ED_AddsOrMultiplies.getText().clear();
            ED_startNum.getText().clear();

            Intent si = new Intent(this, hishov_sdra.class);
            si.putExtra("Switch_yes_no", x);
            si.putExtra("AddsOrMultiplies", a);
            si.putExtra("startNum", b);
            startActivity(si);
        }

    }

}

