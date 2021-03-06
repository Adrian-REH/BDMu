package com.helper.appmu.Donaciones;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.helper.appmu.R;

public class VIP extends Fragment {
    Button Mostrar, btn_tyc ;
    ImageButton vip_1, vip_2,vip_3,vip_4;
Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_vip, container,false);

    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getFragmentManager().beginTransaction().replace(R.id.container,
                    new VIP()).addToBackStack(null).commit();
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getFragmentManager().beginTransaction().replace(R.id.container,
                    new VIP()).addToBackStack(null).commit();
        }
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vip_1 =  view.findViewById(R.id.vip_1);
        vip_2 =  view.findViewById(R.id.vip_2);
        vip_3 =  view.findViewById(R.id.vip_3);
        vip_4 =  view.findViewById(R.id.vip_4);

        Mostrar = view.findViewById(R.id.Mostrar);
        btn_tyc = view.findViewById(R.id.btn_tyc);
        final Dialog builder = new Dialog(getActivity());

        builder.setContentView(R.layout.info_vip_dialog);
        //ESTABLECER ANCHO DEL DIALOGO
        final int width = (int)(getResources().getDisplayMetrics().widthPixels*0.95);
        //ESTABLECER EL ALTO DEL DIALOGO
        final int height =(int)(getResources().getDisplayMetrics().heightPixels*0.8);
        builder.getWindow().setLayout(width,height);


        final ImageButton btnPAYPAL = builder.findViewById(R.id.PAYPAL);
        final ImageButton btnDEPOSITO = builder.findViewById(R.id.DEPOSITO);
        final ImageButton btnAGENCIA = builder.findViewById(R.id.AGENCIA);
        final ImageButton btnPAYU = builder.findViewById(R.id.PAYU);
        final ImageButton btnPAYGOL = builder.findViewById(R.id.PAYGOL);

        Mostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Dialog builder = new Dialog(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.setContentView(R.layout.mostar_dialog);
                //ESTABLECER ANCHO DEL DIALOGO
                final int width = (int)(getResources().getDisplayMetrics().widthPixels*0.95);
                //ESTABLECER EL ALTO DEL DIALOGO
                final int height =(int)(getResources().getDisplayMetrics().heightPixels*0.8);
                builder.getWindow().setLayout(width,height);
                builder.show();

            }
        });
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
                mtyc.setText("1. Jugar en los servidores de HeroesMu es totalmente LIBRE, la adquisici??n de ??tems o servicios es de absoluta elecci??n y decisi??n de cada uno.\n" +
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

        vip_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=7W193814MU827894N&useraction=commit&mfid=1566883433064_f833028e54ed0#/checkout/signup");
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
                btnDEPOSITO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnAGENCIA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYU.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYGOL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

        vip_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=36261305SX925894U&useraction=commit&mfid=1566883412355_14c7d60999521#/checkout/signup");
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
                btnDEPOSITO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnAGENCIA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYU.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYGOL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        vip_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();

                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=93680877WD3882048&useraction=commit&mfid=1566883391828_f95a0a0a1577c#/checkout/signup");
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
                btnDEPOSITO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnAGENCIA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYU.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYGOL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        vip_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=13632367KH719800Y&useraction=commit&mfid=1566883349372_8dd9ea8cb735d#/checkout/signup");
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
                btnDEPOSITO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnAGENCIA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYU.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });
                btnPAYGOL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "ACTUALMENTE NO DISPONIBLE ",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }


}
