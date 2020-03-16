package com.eps.androidconnect4;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class PrefaceConnect4 extends AppCompatActivity {

    EditText alias_field;
    boolean crono;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preface_connect4);
        setTitle("PREFACE");

        alias_field = findViewById(R.id.alias_input);

        ToggleButton toggle = findViewById(R.id.timerButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crono= isChecked;
            }
        });

        final Button playGame= findViewById(R.id.play_game);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PlayerAlias;
                if (alias_field != null) {
                    int seleted_opt = getSelected(findViewById(R.id.grupo));
                    boolean completed =false;


                    if (alias_field.getText().toString().isEmpty() &&  seleted_opt==0 ) {
                        Toast.makeText(getBaseContext(), getString(R.string.no_player_size_toast), Toast.LENGTH_SHORT).show();
                    }else {
                        if (alias_field.getText().toString().isEmpty()) {
                            Toast.makeText(getBaseContext(), getString(R.string.no_player_toast), Toast.LENGTH_SHORT).show();
                            completed=false;
                        }else {
                            completed=true;
                        }
                        if (seleted_opt==0 ) {
                            Toast.makeText(getBaseContext(), getString(R.string.no_size_toast), Toast.LENGTH_SHORT).show();
                            completed=false;
                        }else {
                            completed=true;
                        }
                    }



                    if(completed){
                        PlayerAlias = alias_field.getText().toString();
                        System.out.println("Player Alias="+PlayerAlias+"opt "+seleted_opt+" crono="+crono);
                    }

                }
            }
        });





    }

    private int getSelected(View view) {
        int id_opt_selected = ((RadioGroup) view).getCheckedRadioButtonId();
        int opt=0;

        if (id_opt_selected !=-1){
            RadioButton c = findViewById(id_opt_selected);
            boolean checked = c.isChecked();



            switch (id_opt_selected) {
                case R.id.size_7x7:
                    if (checked) {
                        opt = 7;
                    }
                    break;
                case R.id.size_6x6:
                    if (checked) {
                        opt = 6;
                    }
                    break;

                case R.id.size_5x5:
                    if (checked) {
                        opt = 5;
                    }
                    break;
            }
        }

        return opt;
    }



}
