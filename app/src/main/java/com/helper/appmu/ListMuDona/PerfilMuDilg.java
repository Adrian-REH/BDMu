package com.helper.appmu.ListMuDona;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.helper.appmu.R;

public class PerfilMuDilg extends AppCompatActivity {
Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_mu_dilg);

        btn();
        context = this;


        }



public  void btn(){
    Button btn_fb = findViewById(R.id.btn_fb);
    Button    btn_correo = findViewById(R.id.btn_correo);
    Button    btn_info = findViewById(R.id.btn_info);



    Bundle b = getIntent().getExtras();

    ImageButton image2 = findViewById(R.id.btn_pag);


    // ESTA SECCION DETERMINA LA IMAGEN QUE MANDA -MAIN ACT ADAPTER-
    if(b!=null) {
        String a = b.getString("TIT1");
        getSupportActionBar().setTitle(a);
        //IMAGEN 1
        int bb = b.getInt("image");
        //CON ESTE CODIGO VISUALIZACMOS LA IMAGEN L R K
        image2.setImageResource(bb);
        //Los Links que usara para ingresar a facebook o Foro
        final String c = b.getString("LINK");

        final   String d = b.getString("INFO");
        final   String e = b.getString("PAGE");
        final   String f = b.getString("CORREO");




btn_correo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        final Dialog builder = new Dialog(context);
        builder.setContentView(R.layout.email_1);



        final Button mSendEmailBtn = builder.findViewById(R.id.sendEmailBtn);
        final EditText mRecipientEt = builder.findViewById(R.id.recipientEt);
        final EditText mSubjetEt = builder.findViewById(R.id.subjetEt);
        final EditText mMessagetEt = builder.findViewById(R.id.messageEt);


        mRecipientEt.setText(f);
        mSubjetEt.setText("CONTACTO");
        mMessagetEt.setText("   ");
        try{
            String recipent = mRecipientEt.getText().toString().trim();
            String subjet = mSubjetEt.getText().toString().trim();
            String message = mMessagetEt.getText().toString().trim();


            sendEmail(recipent,subjet,message);

        }
        catch (Exception error){
            Log.e("UPDATE error", error.getMessage());
        }

    }
});

        image2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //El brindamos el dato necesario a Uri

            if(e.equals(null)){

            }else{
                Uri uriUrl = Uri.parse(e);
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }

        }
    });
    btn_fb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //El brindamos el dato necesario a Uri
            Uri uriUrl = Uri.parse(c);
            //Especificamos la accion a realizar con el ACTION_VIEW
            //para que elija lo mas razonable
            Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(intent);
        }
    });


    btn_info.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //INFORMACION QUE SE BRINDA MEDIANTE UN DIALOGO ;D

            final Dialog builder = new Dialog(context);
            LayoutInflater inflater = getLayoutInflater();
            builder.setContentView(R.layout.term_condiciones);
            TextView mtyc = builder.findViewById(R.id.messageEt);

            //ESTABLECER ANCHO DEL DIALOGO
            final int width = (int)(getResources().getDisplayMetrics().widthPixels);
            //ESTABLECER EL ALTO DEL DIALOGO
            final int height =(int)(getResources().getDisplayMetrics().heightPixels*0.9);
            builder.getWindow().setLayout(width,height);
            mtyc.setText(d);
            builder.show();
        }
    });



    }

    }

    final private void sendEmail(String recipent, String subjet, String message) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);

        mEmailIntent.setData(Uri.parse(("mailto:")));
        mEmailIntent.setType("text/plain");
        mEmailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipent});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT,subjet);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT,message);
        try{
            startActivity(Intent.createChooser(mEmailIntent,"Choose an Email Client"));

        }
        catch (Exception e){


        }
    }


}
