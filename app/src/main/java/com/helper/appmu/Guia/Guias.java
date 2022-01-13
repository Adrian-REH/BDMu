package com.helper.appmu.Guia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.helper.appmu.R;

import java.util.ArrayList;

public class Guias extends Fragment {
    Button btn_in,btn_pr,btn_av;
    ArrayList<String> adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_guias, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btn_pr = view.findViewById(R.id.btn_pr);
        btn_in = view.findViewById(R.id.btn_in);
        btn_av = view.findViewById(R.id.btn_av);
final String one = btn_pr.getText().toString().trim();
        final String two = btn_in.getText().toString().trim();
        final String tre = btn_av.getText().toString().trim();

        btn_pr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new ListaGuias()).addToBackStack(null).commit();
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                ActionBar actionBar = activity.getSupportActionBar();
                actionBar.setTitle(one);

            }
        });
        btn_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new ListaGuias2()).addToBackStack(null).commit();
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                ActionBar actionBar = activity.getSupportActionBar();
                actionBar.setTitle(two);
            }
        });
        btn_av.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getFragmentManager().beginTransaction().replace(R.id.container,
                        new ListaGuias3()).addToBackStack(null).commit();
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                ActionBar actionBar = activity.getSupportActionBar();
                actionBar.setTitle(tre);
            }
        });
    }

}
