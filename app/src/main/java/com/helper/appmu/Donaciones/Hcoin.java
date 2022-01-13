package com.helper.appmu.Donaciones;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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


public class Hcoin extends Fragment {
Context context;
    Button btn_tyc ;
    ImageButton hc_1, hc_2,hc_3,hc_4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_hcoin, container,false);

    }
  /*  @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getFragmentManager().beginTransaction().replace(R.id.container,
                    new Hcoin()).addToBackStack(null).commit();
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            getFragmentManager().beginTransaction().replace(R.id.container,
                    new Hcoin()).addToBackStack(null).commit();
        }
    } */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hc_1 = (ImageButton) view.findViewById(R.id.hc_1);
        hc_2 = (ImageButton) view.findViewById(R.id.hc_2);
        hc_3 = (ImageButton) view.findViewById(R.id.hc_3);
        hc_4 = (ImageButton) view.findViewById(R.id.hc_4);

        btn_tyc = (Button)view.findViewById(R.id.btn_tyc);
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
                mtyc.setText("1. Jugar en los servidores de HeroesMu es totalmente LIBRE, la adquisición de ítems o servicios es de absoluta elección y decisión de cada uno.\n" +
                        "\n" +
                        "2. Los valores abonados por ítems o servicios son en calidad de donación para el mantenimiento de los servidores, bajo ninguna circunstancia serán reembolsados.\n" +
                        "\n" +
                        "3. HeroesMu no da ningun tipo de garantia en items full.\n" +
                        "\n" +
                        "4. El comercio de los ítems adquiridos esta totalmente prohibido tanto dentro del juego como fuera de él, Este es motivo de baneo automático de la cuenta sin derecho a reclamo alguno.\n" +
                        "\n" +
                        "5. No hay por ningún motivo cambio ni devolución de ítems adquiridos, tampoco se permite pasar ítems comprados en esta tienda a otra cuenta, si los ADMINISTRADORES se dan cuenta que esto es así, el set que este fuera de su lugar correspondiente será eliminado inmediatamente.\n" +
                        "\n" +
                        "6. No se repondrán ítems comprados que se haya vendido en las tiendas del servidor.\n" +
                        "\n" +
                        "7. Todos los usuarios tienen los mismos derechos y obligaciones y se aplican las mismas reglas. en el caso de infringir las reglas del juego (usar cheats, hacks, robar ítems, engañar gente, estafar, duplicar ítems, etc.) las cuentas serán baneadas con todo lo que tengan dentro y posteriormente eliminadas.\n" +
                        "\n" +
                        "8. Al Ingresar y efectuar tus pedidos estas aceptando estos Términos y Condiciones.\n" +
                        "\n" +
                        "9. Las DONACIONES se acreditan dentro de las 24 a 48hs solo días hábiles, una vez acreditado se entregaran los ítems comprados en el baúl.\n" +
                        "\n" +
                        "10. Asegurese de elegir bien sus opciones Jewel Harmony(opcion amarilla) o Socket option(solo S4) por que después no se hace ningún tipo de cambio, si despues quieren hacer algún cambio de opciones tendrán que hacerlo ustedes mismo en los respectivos NPC.\n" +
                        "\n" +
                        "Las donaciones se expresan en dólares para todos los Países.");

                builder.show();
            }
        });

        hc_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=8GA460348U513212N&useraction=commit&mfid=1566882614919_db31391a2e396#/checkout/signup");
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

                     /*   try{

                            AlertDialog.Builder builder= new AlertDialog.Builder(context);
                            builder.setTitle("PAIS").setMessage("Elije el Pais que pertenezcas para donar en PayU").setPositiveButton("PERU",
                                    new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {


                                }
                            }).setNegativeButton("Colombia", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {




                                    dialog.dismiss();
                                }
                            });

                            AlertDialog alertDialog = builder.create();

                            alertDialog.show();







                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("http://www.heroesmu.com/banco.htm");
                            //Especificamos la accion a realizar con el ACTION_VIEW
                            //para que elija lo mas razonable
                            Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(intent);
                        }
                        catch (Exception error){
                            Log.e("UPDATE error", error.getMessage());
                        } */

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

        hc_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=4YH17636RJ3268116&useraction=commit&mfid=1566882973150_d4d38d8d5c894#/checkout/signup");
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

        hc_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();

                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=8FL78061D9736235C&useraction=commit&mfid=1566883003807_a239bc271c46f#/checkout/signup");
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
        hc_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                builder.show();

                btnPAYPAL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            //El brindamos el dato necesario a Uri
                            Uri uriUrl = Uri.parse("https://www.paypal.com/webapps/hermes?token=8GK009984U3903916&useraction=commit&mfid=1566883022907_ce1ce88d305c6#/checkout/signup");
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
