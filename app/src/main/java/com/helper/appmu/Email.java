package com.helper.appmu;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Fragment {

    Button btn_tyc,btn_e1,btn_e2,btn_e3 ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email, container,false);

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getFragmentManager().beginTransaction().replace(R.id.container,
                    new Email()).addToBackStack(null).commit();
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getFragmentManager().beginTransaction().replace(R.id.container,
                    new Email()).addToBackStack(null).commit();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_e1 = (Button) view.findViewById(R.id.btn_e1);
        btn_e2 = (Button) view.findViewById(R.id.btn_e2);
        btn_e3 = (Button) view.findViewById(R.id.btn_e3);


        btn_tyc = (Button)view.findViewById(R.id.btn_tyc);
        final Dialog builder = new Dialog(getActivity());
        builder.setContentView(R.layout.email_1);



        final Button mSendEmailBtn = builder.findViewById(R.id.sendEmailBtn);
        final EditText mRecipientEt = builder.findViewById(R.id.recipientEt);
        final EditText mSubjetEt = builder.findViewById(R.id.subjetEt);
        final EditText mMessagetEt = builder.findViewById(R.id.messageEt);




        btn_tyc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Dialog builder = new Dialog(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.setContentView(R.layout.term_condiciones);
                TextView mtyc = builder.findViewById(R.id.messageEt);

                //ESTABLECER ANCHO DEL DIALOGO
                final int width = (int)(getResources().getDisplayMetrics().widthPixels);
                //ESTABLECER EL ALTO DEL DIALOGO
                final int height =(int)(getResources().getDisplayMetrics().heightPixels*0.9);
                builder.getWindow().setLayout(width,height);

                mtyc.setText("Hola, Muchas gracias por utilizar AyudaMU, esta es una App de Dexter Ñerk, una marca iniciante en el desarrollo de Date Base," +
                        " Si tiene algun inconveniente puede contactar con El desarrollador de la App." +
                        " Ten en cuenta que todo archivo incluido en esta App pertenece a Dexter Ñerk," +
                        " usted es libre de dibulgar el contenido, sin omitir el nombre Dexter Ñerk como creador del mismo." +
                        " Muchas Gracias por su consideracion. ");
                builder.show();
            }
        });
        btn_e1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mRecipientEt.setText("bddnerk@gmail.com");
                mSubjetEt.setText("CONTACTO");
                mMessagetEt.setText("   ");
             /*  mMessagetEt.setText("*ID del server (NO contraseña)\n" +
                        "*Servidor, Xtreme Season 8 episodio 3\n" +
                        "*Correo con el que hiciste la donación\n" +
                        "*Fecha que se realizó el pago\n" +
                        "*Adjuntar el comprobante de pago, en caso de no tener escaner, dejar los datos de este mismo\n" +
                        ">> Como por ejemplo en DineroMail: nro. operacion manual, ID operacion:\n" +
                        "\n" +
                        "\n" +
                        "*Días VIP pagados y el monto abonado, en el caso de repartir días vip, deben aclararlo detalladamente asi evitamos errores en la distribución. Recuerden, hasta 3 cuentas máximo y las fraciones de dias vip entre mas cuentas es de 30 dias en adelante\n" +
                        "*También se puede aclarar los días que te llegan por estar en época de promoción, para facilitar el trabajo de los moderadores.");*/
                LayoutInflater inflater = getActivity().getLayoutInflater();
                try{
                    ;
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
       btn_e2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:00000"));
                startActivity(intent);

            }
        });

        btn_e3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //El brindamos el dato necesario a Uri
                Uri uriUrl = Uri.parse("https://www.facebook.com/Dexter-Ñerk-322345768672164/?modal=admin_todo_tour");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);

            }
        });


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
