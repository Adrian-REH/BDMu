package com.helper.appmu;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class FragmentContent extends Fragment {
    ImageButton btn_pag ;
    Button btn_wp, btn_fb, btn_foro;
    private static final String KEY_TITLE="Content";
    public FragmentContent() {
        // Required empty public constructor
    }

    public static FragmentContent newInstance(String param1) {
        FragmentContent fragment = new FragmentContent();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_content, container, false);



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getFragmentManager().beginTransaction().replace(R.id.container,
                    new FragmentContent()).addToBackStack(null).commit();
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getFragmentManager().beginTransaction().replace(R.id.container,
                    new FragmentContent()).addToBackStack(null).commit();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_pag = (ImageButton) view.findViewById(R.id.btn_pag);
        btn_wp = (Button) view.findViewById(R.id.btn_wp);
        btn_fb = (Button) view.findViewById(R.id.btn_fb);



        btn_pag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //El brindamos el dato necesario a Uri
                Uri uriUrl = Uri.parse("http://www.heroesmu.com/index.htm");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
        btn_fb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //El brindamos el dato necesario a Uri
                Uri uriUrl = Uri.parse("https://www.facebook.com/HeroesNetworks.Oficial/");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
         btn_wp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+5214521767269"));
                startActivity(intent);


            }
        });


    }


}
