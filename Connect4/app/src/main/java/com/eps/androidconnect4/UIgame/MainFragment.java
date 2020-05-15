package com.eps.androidconnect4.UIgame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.eps.androidconnect4.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    public static Activity a;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            a =(Activity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Android Connect4");
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Button btn_help = v.findViewById(R.id.button_help);
        Button btn_preamble = v.findViewById(R.id.goPreamble);
        Button btn_exit = v.findViewById(R.id.button_exit);

        btn_help.setOnClickListener(this);
        btn_preamble.setOnClickListener(this);
        btn_exit.setOnClickListener(this);

        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void onClick(View v) {
        switch ( v.getId()){
            case R.id.button_help:
                Toast.makeText(getContext(),"HELP",Toast.LENGTH_LONG).show();
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_helpFragment);

                break;
            case R.id.goPreamble:
                Toast.makeText(getContext(),"preamble",Toast.LENGTH_LONG).show();
                Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_preambleFragment);
                break;
            case R.id.button_exit:
                a.finishAffinity();
                a.finish();
                break;
        }

    }
}
