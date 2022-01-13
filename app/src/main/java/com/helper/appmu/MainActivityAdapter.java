package com.helper.appmu;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.helper.appmu.Guia.ActivityGuiaIntermedio;

import java.util.ArrayList;
import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.Holderview> {
private List<Item> productlist;
    private static final String TAG = "MainActivityAdapter";
private Context context;
private Context contexto;
    public MainActivityAdapter(List<Item> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
        this.contexto = context;

    }

    @Override
    public Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.customitem,parent,false);

        return new Holderview(layout);


    }

    @Override
    public void onBindViewHolder(Holderview holder, final int position) {
        holder.v_name.setText(productlist.get(position).getName());
        holder.v_image.setImageResource(productlist.get(position).getPhoto());
        final String name = productlist.get(position).getName();
        Log.d(TAG, "onBindViewHolder: called.");

        final Intent intent = new Intent(context, ActivityGuiaIntermedio.class);

        intent.putExtra("TIT",name);


        holder.itemView.setOnClickListener(new View.OnClickListener(){
    @Override
    //ABRIMOS SI ENCONTRAMOS EL NOMBRE DEL ARCHIVO
    public  void onClick(View view){
        //LISTA DE GUIAS SISTEMA DE ELEMENTOS!!!!

            if (name.equals("Crear Errtel")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.ert);
                intent.putExtra("image_url2",R.drawable.ert2);
            context.startActivity(intent);
        }else
          if (name.equals("Nivel de un Errtel")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
              intent.putExtra("image_url",R.drawable.ertup);
              intent.putExtra("image_url2",R.drawable.ert2);
            context.startActivity(intent);
        }else
          if (name.equals("Rank de un Errtel")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
              intent.putExtra("image_url",R.drawable.ertupr);
            context.startActivity(intent);
        }else
          if (name.equals("Descomponer un Errtel")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
              intent.putExtra("image_url",R.drawable.ertud);
            context.startActivity(intent);
        }else
            if (name.equals("Crear Expansion Scroll of Radiance slot")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.esr);
            context.startActivity(intent);
        }else
            if (name.equals("Pentagramas")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.pntg);
                intent.putExtra("image_url2",R.drawable.pntg2);
            context.startActivity(intent);
        }

            //LISTA DE GUIAS QUEST!!!!


            else
            if (name == "Quest Primera Evolucion"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.qst1);
            context.startActivity(intent);
        }else
            if (name == "Quest Segunda Evolucion"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.qst2);
            context.startActivity(intent);
        }else
            if (name == "Quest Tercera Evolucion"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS

                intent.putExtra("image_url",R.drawable.qst31);
                intent.putExtra("image_url2",R.drawable.qst32);
                intent.putExtra("image_url3",R.drawable.qst335);
                intent.putExtra("image_url4",R.drawable.qst34);

            context.startActivity(intent);
        }else
            if (name == "Quest Cuarta Evolucion"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.qst4);
                intent.putExtra("image_url2",R.drawable.qst42);
            context.startActivity(intent);
        }else
            if (name.equals("Quest Skill Tree Reset Points")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.rstsk);
                intent.putExtra("image_url2",R.drawable.rstsk2);
            context.startActivity(intent);
        }else
            if (name.equals("Quest de Inventario y Baul")){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.inv);
            context.startActivity(intent);
        }
        //LISTA DE GUIAS CREAR ITEMS!!




        else
            if (name == "Wings Level 3"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.wngs31);
                intent.putExtra("image_url2",R.drawable.wngs32);
            context.startActivity(intent);
        }else
            if (name == "Condor Feather"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                intent.putExtra("image_url",R.drawable.wngscf);
            context.startActivity(intent);
        }else
        if (name == "Opciones 380"){
            intent.putExtra("image_url",R.drawable.itmop380);
            contexto.startActivity(intent);
        }else
        if (name == "Armas Socket"){

            context.startActivity(intent);
        }else
        if (name == "Wings Level 1"){
            intent.putExtra("image_url",R.drawable.wngs1);

            context.startActivity(intent);
        }else
        if (name == "Wings Level 2"){
            intent.putExtra("image_url",R.drawable.wngs2);

            context.startActivity(intent);
        }else
        if (name == "Chaos Weapon"){
            intent.putExtra("image_url",R.drawable.wngscw);
            context.startActivity(intent);
        }else
        if (name == "Monster Wings 2.5"){
            intent.putExtra("image_url",R.drawable.wngs251);
            intent.putExtra("image_url2",R.drawable.wngs252);
            context.startActivity(intent);
        }else
        if (name == "Horn of Fenrir Blue"){
            intent.putExtra("image_url",R.drawable.fenb);
            context.startActivity(intent);
        }
        else
        if (name == "Horn of Fenrir Black"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
            intent.putExtra("image_url",R.drawable.fenbck);
            context.startActivity(intent);
        }else
        if (name == "Broken Horn"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
            intent.putExtra("image_url",R.drawable.fenbh);
            context.startActivity(intent);
        }else
        if (name == "Fragment of Horn"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
            intent.putExtra("image_url",R.drawable.fenfh);
            context.startActivity(intent);
        }else
        if (name == "Horn of Fenrir Red"){
            //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
            intent.putExtra("image_url",R.drawable.fenr);
            context.startActivity(intent);
        }else
        if (name == "Wings Level 4"){
            intent.putExtra("image_url",R.drawable.wngs41);
            intent.putExtra("image_url2",R.drawable.wngs42);
            contexto.startActivity(intent);
        }else
        if (name == "Blessed Divine of Archangel"){
            intent.putExtra("image_url",R.drawable.archa);
            context.startActivity(intent);
        }else
        if (name == "Set Item Bloodangel"){
            intent.putExtra("image_url",R.drawable.itmbl);
            context.startActivity(intent);
        }else
        if (name == "Set Item Darkangel"){
            intent.putExtra("image_url",R.drawable.itmda);
            context.startActivity(intent);
        }else
        if (name == "Set Item Holyangel"){
            intent.putExtra("image_url",R.drawable.itmho);
            context.startActivity(intent);
        }else
        if (name == "Magic Stone"){
            intent.putExtra("image_url",R.drawable.mgst);
            context.startActivity(intent);
        }else
        if (name == "Garuda Feather"){
            intent.putExtra("image_url",R.drawable.wngsgf);
            context.startActivity(intent);
        } else

            if (name == "Set Item Awakening"){
                intent.putExtra("image_url",R.drawable.itmaw);
                context.startActivity(intent);
            }else
                if (name == "Weapons Darkangel"){
                    intent.putExtra("image_url",R.drawable.wpnda);
                context.startActivity(intent);
            }else
                if (name == "Weapons Holyangel"){
                    intent.putExtra("image_url",R.drawable.wpnho);
                context.startActivity(intent);
            }else
                if (name == "Weapons Awakening"){
                    intent.putExtra("image_url",R.drawable.wpnso);
                context.startActivity(intent);
            }else
                if (name == "Ancient Hero Soul"){
                    intent.putExtra("image_url",R.drawable.anheso);
                context.startActivity(intent);
            }

    }
});
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    public void setfilter(List<Item>listitem)
{
    productlist=new ArrayList<>();
    productlist.addAll(listitem);

    notifyDataSetChanged();
}
    public class Holderview extends RecyclerView.ViewHolder{
        public     ImageView v_image;
        public  TextView v_name;


        public Holderview(View interview){
            super(interview);
            v_image=(ImageView) interview.findViewById(R.id.product_img);
            v_name=(TextView) interview.findViewById(R.id.product_title);

        }
    }
}
