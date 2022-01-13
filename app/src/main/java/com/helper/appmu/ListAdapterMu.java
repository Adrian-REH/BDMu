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

import com.helper.appmu.ListMuDona.PerfilMuDilg;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterMu extends RecyclerView.Adapter<ListAdapterMu.Holderview> {
    private List<Item1> productlist1;
    private static final String TAG = "ListAdapterMU";
    private Context context;
    private Context contexto;
    public ListAdapterMu(List<Item1> productlist, Context context) {
        this.productlist1 = productlist;
        this.context = context;
        this.contexto = context;
    }

    @Override
    public ListAdapterMu.Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.customsrvmu,parent,false);

        return new ListAdapterMu.Holderview(layout);
    }

    @Override
    public void onBindViewHolder(ListAdapterMu.Holderview holder, final int position) {
        holder.v_name.setText(productlist1.get(position).getName());
        holder.v_image.setImageResource(productlist1.get(position).getPhoto());


        final String name = productlist1.get(position).getName();
        final String link = productlist1.get(position).getLink();
        final String info = productlist1.get(position).getInfo();
        Log.d(TAG, "onBindViewHolder: called.");

        final Intent intent = new Intent(context, PerfilMuDilg.class);
        intent.putExtra("TIT1",name);
        intent.putExtra("LINK",link);
        intent.putExtra("INFO",info);
        intent.putExtra("PAGE",info);
        intent.putExtra("CORREO",info);


        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            //ABRIMOS SI ENCONTRAMOS EL NOMBRE DEL ARCHIVO
            public  void onClick(View view){

                if (name == "GAME MU"){
                    //INTENTA ABRIR Y MANDA image_url CON EL NOMBRE DE LA IMAGEN QUE USAREMOS
                    intent.putExtra("image",R.drawable.nk2);
                    context.startActivity(intent);
                }else
                if (name == "MU3"){
                    intent.putExtra("image",R.drawable.nk);

                    context.startActivity(intent);
                }else
                if (name == "MU2"){
                    intent.putExtra("image",R.drawable.nk);

                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return productlist1.size();
    }

    public void setfilter(List<Item1>listitem)
    {
        productlist1=new ArrayList<>();
        productlist1.addAll(listitem);
        notifyDataSetChanged();
    }
    public class Holderview extends RecyclerView.ViewHolder{
        public ImageView v_image;
        public TextView v_name;



        public Holderview(View interview){
            super(interview);
            v_image=interview.findViewById(R.id.banner);
            v_name=interview.findViewById(R.id.title);


        }
    }
}
