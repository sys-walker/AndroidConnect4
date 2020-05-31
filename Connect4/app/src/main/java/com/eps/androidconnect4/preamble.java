package com.eps.androidconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;



public class preamble extends AppCompatActivity implements View.OnClickListener {
    EditText alias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preamble);
        setTitle(R.string.preamble_screen);

        Button commence_btn = findViewById(R.id.commence_game);
        alias = findViewById(R.id.alias_in);
        commence_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch ( v.getId()){
            case R.id.commence_game:
                int mida_graella = getGameSize();
                boolean control_temps = getTimeOption();
                Intent in= new Intent(this, Connect4GameActivity.class);
                if (control_temps){
                    in.putExtra(constants.KEY_TIME_CTRL,control_temps);

                }
                in.putExtra(constants.KEY_BOARD_SIZE,mida_graella);
                startActivity(in);
                finish();
                break;
        }
    }


    private boolean getTimeOption(){
        ToggleButton t = findViewById(R.id.toggleButton);
        if (t != null) {
            return t.isChecked();
        }
        return false;

    }
    private int getGameSize() {
        RadioGroup r = findViewById(R.id.graella_radiogrup);
        if (r != null) {
            int id = r.getCheckedRadioButtonId();
            switch (id){
                case R.id.grid7:
                    return 7;
                case R.id.grid6:
                    return 6;
                case R.id.grid5:
                    return 5;
            }
        }

        Toast.makeText(getBaseContext(),R.string.error_size_grid,Toast.LENGTH_LONG).show();
        return 7;

    }
}
