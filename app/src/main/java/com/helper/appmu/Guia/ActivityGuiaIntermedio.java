package com.helper.appmu.Guia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;

import com.helper.appmu.R;

public class ActivityGuiaIntermedio extends AppCompatActivity  {

ImageView img_guia,Img_guia2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_intermedio);

        Bundle b = getIntent().getExtras();

        ImageView image = findViewById(R.id.img_guia);
        ImageView image2 = findViewById(R.id.img_guia2);
        ImageView image3 = findViewById(R.id.img_guia3);
        ImageView image4 = findViewById(R.id.img_guia4);

        // ESTA SECCION DETERMINA LA IMAGEN QUE MANDA -MAIN ACT ADAPTER-
        if(b!=null) {
            String i = b.getString("TIT");
            getSupportActionBar().setTitle(i);
            //IMAGEN 1
            int r = b.getInt("image_url");
            //IMAGEN 2
            int k = b.getInt("image_url2");
            //IMAGEN 3
            int l = b.getInt("image_url3");
            //IMAGEN 4
            int h = b.getInt("image_url4");
            //CON ESTE CODIGO VISUALIZACMOS LA IMAGEN L R K
            image.setImageResource(r);
            image2.setImageResource(k);
            image3.setImageResource(l);
            image4.setImageResource(h);
        }
    }

}
