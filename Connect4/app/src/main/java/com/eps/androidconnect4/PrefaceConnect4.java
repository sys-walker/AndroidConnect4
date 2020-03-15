package com.eps.androidconnect4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class PrefaceConnect4 extends AppCompatActivity {

    EditText alias_field;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preface_connect4);
        setTitle("PREFACE");

        alias_field = findViewById(R.id.alias_input);

        final Button playGame= findViewById(R.id.play_game);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PlayerAlias;
                if (alias_field != null) {
                    if (alias_field.getText().toString().isEmpty()) {

                        Toast.makeText(getBaseContext(), getString(R.string.no_player_toast), Toast.LENGTH_SHORT).show();
                    } else {
                        PlayerAlias = alias_field.getText().toString();
                        System.out.println("Player Alias="+PlayerAlias);
                    }

                }
            }
        });




    }
}
