package com.eps.androidconnect4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class helpFragment extends Fragment implements View.OnClickListener {

    public helpFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Ajuda");
        View v = inflater.inflate(R.layout.fragment_help, container, false);
        Button b = v.findViewById(R.id.button_b_main);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId()){
            case R.id.button_b_main:
                Toast.makeText(getContext(),"BACK",Toast.LENGTH_LONG).show();
                Navigation.findNavController(v).navigate(R.id.action_helpFragment_to_mainFragment);
                break;
        }
    }
}
