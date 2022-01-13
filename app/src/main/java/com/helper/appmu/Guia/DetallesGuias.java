package com.helper.appmu.Guia;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.helper.appmu.R;
public class DetallesGuias extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_detalles_guias, container,false);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titulo =  view.findViewById(R.id.tbTituloDescripcion);

        Intent intent = getActivity().getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            String i = b.getString("TIT");
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(i);
            titulo.setText(b.getString("TIT"));
        }
    }

}
