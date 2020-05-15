package com.eps.androidconnect4.UIgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.eps.androidconnect4.MainActivity;
import com.eps.androidconnect4.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class preamble extends Fragment implements View.OnClickListener {
    EditText alias;
    View inflated;

    public preamble() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Configuració");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_preamble, container, false);
        inflated = v;
        Button commence_btn = v.findViewById(R.id.commence_game);
        alias = v.findViewById(R.id.alias_in);
        commence_btn.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId()){
            case R.id.commence_game:
                MainActivity.b.putString("ALIAS", alias.getText().toString());
                MainActivity.b.putInt("MIDA_GRAELLA",getGameSize());

                Toast.makeText(getContext(),"commencing",Toast.LENGTH_LONG).show();
                Navigation.findNavController(v).navigate(R.id.action_preambleFragment_to_connect4Fragment);
                break;
        }

    }

    private int getGameSize() {
        RadioGroup r = inflated.findViewById(R.id.graella_radiogrup);
        int id = r.getCheckedRadioButtonId();
        switch (id){
            case R.id.grid7:
                return 7;
            case R.id.grid6:
                return 6;
            case R.id.grid5:
                return 5;
        }
        Toast.makeText(getContext(),"Error Mida, default =7",Toast.LENGTH_LONG).show();
        return 7;


    }
}
