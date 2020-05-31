package com.eps.androidconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;



import java.util.ArrayList;

public class Connect4GameActivity extends AppCompatActivity {
    private static Game game;
    public  ImageAdapter buttonAdapter;
    public GridView buttons_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4_game);

        int size= getIntent().getIntExtra(constants.KEY_BOARD_SIZE,7);
        game = new Game(size,size,4);

        //COLOCAR BUTTONS
        GridView grid = findViewById(R.id.gridviewbuttons);
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            b.add(R.drawable.fitxa_vermell);
        }
        ImageAdapter Adapter = new ImageAdapter(getBaseContext());
        Adapter.putArray(b.toArray(new Integer[0]));
        grid.setNumColumns(size);
        grid.setAdapter(Adapter);

        //////////////////////////////////////////////////
        buttons_grid = findViewById(R.id.gridview2);
        ArrayList<Integer> buttons = new ArrayList<>();
        for (int i = 0; i < size *size ; i++) {
            buttons.add(R.drawable.fitxa_buida);
        }
        buttonAdapter = new ImageAdapter(getBaseContext());
        buttonAdapter.putArray(buttons.toArray(new Integer[0]));

        buttons_grid.setBackgroundColor(Color.BLUE);
        buttons_grid.setNumColumns(size);
        buttons_grid.setAdapter(buttonAdapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int column = position;
                if(game.canPlayColumn(column)){
                    Toast.makeText(getBaseContext(),"Jugant a Columna "+position,Toast.LENGTH_LONG).show();
                    Move move = game.play(column);
                    int fila = move.getPosition().getRow();
                    int columna = move.getPosition().getColumn();
                    Toast.makeText(getBaseContext(),"ficat a ("+fila+"-"+columna+")",Toast.LENGTH_LONG).show();
                    buttonAdapter.add_position(fila,columna,R.drawable.fitxa_vermell);
                    buttons_grid.setAdapter(buttonAdapter);
                    buttons_grid.deferNotifyDataSetChanged();
                    if (game.isFinished()){
                        Toast.makeText(getBaseContext(),"FINAL",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getBaseContext(),"Columna a FULL",Toast.LENGTH_LONG).show();

                }

            }
        });

//////////////////////////////////////////////////////////////////////////////////////////////


    }
}
