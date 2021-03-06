package com.helper.appmu;

import android.annotation.SuppressLint;
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

public class EmailD extends Fragment {

    Button btn_tyc,btn_otro,btn_ev,btn_eh,btn_ei ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email_d, container,false);

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
        btn_ev = view.findViewById(R.id.btn_ev);
        btn_eh = view.findViewById(R.id.btn_eh);
        btn_ei = view.findViewById(R.id.btn_ei);
        btn_otro = view.findViewById(R.id.btn_otro);


        btn_tyc = view.findViewById(R.id.btn_tyc);
        final Dialog builder = new Dialog(getActivity());
        builder.setContentView(R.layout.email_1);



        final Button mSendEmailBtn = builder.findViewById(R.id.sendEmailBtn);
        final EditText mRecipientEt = builder.findViewById(R.id.recipientEt);
        final EditText mSubjetEt = builder.findViewById(R.id.subjetEt);
        final EditText mMessagetEt = builder.findViewById(R.id.messageEt);




        btn_tyc.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
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

                mtyc.setText("\n" +
                        "1. Jugar en los servidores de HeroesMu es totalmente LIBRE, la adquisici??n de ??tems o servicios es de absoluta elecci??n y decisi??n de cada uno.\n" +
                        "\n" +
                        "2. Los valores abonados por ??tems o servicios son en calidad de donaci??n para el mantenimiento de los servidores, bajo ninguna circunstancia ser??n reembolsados.\n" +
                        "\n" +
                        "3. HeroesMu no da ningun tipo de garantia en items full.\n" +
                        "\n" +
                        "4. El comercio de los ??tems adquiridos esta totalmente prohibido tanto dentro del juego como fuera de ??l, Este es motivo de baneo autom??tico de la cuenta sin derecho a reclamo alguno.\n" +
                        "\n" +
                        "5. No hay por ning??n motivo cambio ni devoluci??n de ??tems adquiridos, tampoco se permite pasar ??tems comprados en esta tienda a otra cuenta, si los ADMINISTRADORES se dan cuenta que esto es as??, el set que este fuera de su lugar correspondiente ser?? eliminado inmediatamente.\n" +
                        "\n" +
                        "6. No se repondr??n ??tems comprados que se haya vendido en las tiendas del servidor.\n" +
                        "\n" +
                        "7. Todos los usuarios tienen los mismos derechos y obligaciones y se aplican las mismas reglas. en el caso de infringir las reglas del juego (usar cheats, hacks, robar ??tems, enga??ar gente, estafar, duplicar ??tems, etc.) las cuentas ser??n baneadas con todo lo que tengan dentro y posteriormente eliminadas.\n" +
                        "\n" +
                        "8. Al Ingresar y efectuar tus pedidos estas aceptando estos T??rminos y Condiciones.\n" +
                        "\n" +
                        "9. Las DONACIONES se acreditan dentro de las 24 a 48hs solo d??as h??biles, una vez acreditado se entregaran los ??tems comprados en el ba??l.\n" +
                        "\n" +
                        "10. Asegurese de elegir bien sus opciones Jewel Harmony(opcion amarilla) o Socket option(solo S4) por que despu??s no se hace ning??n tipo de cambio, si despues quieren hacer alg??n cambio de opciones tendr??n que hacerlo ustedes mismo en los respectivos NPC.\n" +
                        "\n" +
                        "Las donaciones se expresan en d??lares para todos los Pa??ses.");
                builder.show();
            }
        });
        btn_otro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    //El brindamos el dato necesario a Uri
                    Uri uriUrl = Uri.parse("http://www.heroes-networks.com/heroes-networks/heroes-networks/donaciones/guias-como-donar");
                    //Especificamos la accion a realizar con el ACTION_VIEW
                    //para que elija lo mas razonable
                    Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(intent);
                }
                catch (Exception error){
                    Log.e("UPDATE error", error.getMessage());
                }
            }
        });
        btn_ev.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                mRecipientEt.setText("vip@heroes-networks.com");
                mSubjetEt.setText("DONACION PARA VIP");
               mMessagetEt.setText("*ID del server (NO contrase??a)\n" +
                       "*Servidor, Xtreme Season 8 episodio 3\n" +
                       "*Correo con el que hiciste la donaci??n\n" +
                       "*Fecha que se realiz?? el pago\n" +
                       "*Adjuntar el comprobante de pago, en caso de no tener escaner, dejar los datos de este mismo\n" +
                       ">> Como por ejemplo en DineroMail: nro. operacion manual, ID operacion:\n" +
                       "\n" +
                       "\n" +
                       "*D??as VIP pagados y el monto abonado, en el caso de repartir d??as vip, deben aclararlo detalladamente asi evitamos errores en la distribuci??n. Recuerden, hasta 3 cuentas m??ximo y las fraciones de dias vip entre mas cuentas es de 30 dias en adelante\n" +
                       "*Tambi??n se puede aclarar los d??as que te llegan por estar en ??poca de promoci??n, para facilitar el trabajo de los moderadores.");
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
        btn_eh.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                mRecipientEt.setText("soporte@heroes-networks.com");
                mSubjetEt.setText("DONACION PARA HCOIN");
                mMessagetEt.setText("*ID del server (NO contrase??a)\n" +
                        "*Servidor, Xtreme Season 8 episodio 3\n" +
                        "*Correo con el que hiciste la donaci??n\n" +
                        "*Fecha que se realiz?? el pago\n" +
                        "*Adjuntar el comprobante de pago, en caso de no tener escaner, dejar los datos de este mismo.\n" +
                        "*Cantidad de cr??ditos que compraste, en el caso de estar en ??poca de promoci??n, pueden aclararlo y decir cuantos cr??ditos deben llegarle, para facilitar el trabajo de los admins.");
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

        btn_ei.setOnClickListener(new View.OnClickListener(){

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){

                mRecipientEt.setText("sets@heroes-networks.com");
                mSubjetEt.setText("DONACION PARA SET");
                mMessagetEt.setText("*ID del server (NO contrase??a)\n" +
                        "*Servidor, Xtreme Season 8 episodio 3\n" +
                        "*Correo con el que hiciste la donaci??n\n" +
                        "*Fecha que se realiz?? el pago\n" +
                        "*Adjuntar el comprobante de pago, en caso de no tener escaner, dejar los datos de este mismo.\n" +
                        "*Elegir opciones, ya sea opciones socket, opciones moradas o amarillas.\n" +
                        "*Sets el cual compraron, en caso de recibir dos, determinar las dos cuentas a las cuales van los sets o si van los dos a la misma y por ??ltimo, cuales son estos.");
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
