package com.eps.androidconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_help = findViewById(R.id.button_help);
        Button btn_preamble = findViewById(R.id.goPreamble);
        Button btn_exit = findViewById(R.id.button_exit);

        btn_help.setOnClickListener( this);
        btn_preamble.setOnClickListener(this);
        btn_exit.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        Intent in;
        switch ( v.getId()){
            case R.id.button_help:
                in= new Intent(this, helpActivity.class);
                startActivity(in);
                finish();

                break;
            case R.id.goPreamble:
                in = new Intent(this, preamble.class);
                startActivity(in);
                finish();
                break;
            case R.id.button_exit:
                finish();
                break;
        }
    }
}
