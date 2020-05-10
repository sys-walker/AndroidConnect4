package com.eps.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.gridview);

        ImageAdapter imageAdapter = new ImageAdapter(this);
        int size=6; //got from data Tranfer

        gridview.setNumColumns(size);
        for (int i = 0; i < size*size ; i++) {
            imageAdapter.add(R.drawable.fitxa_buida);
        }
        imageAdapter.Arrayize();
        gridview.setAdapter(imageAdapter);

    }
}
