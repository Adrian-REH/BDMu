package com.helper.appmu.Guia;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.helper.appmu.Item;
import com.helper.appmu.MainActivityAdapter;

import com.helper.appmu.R;

import java.util.ArrayList;
import java.util.List;

public class ListaGuias extends Fragment {
    ListView lista;
    SearchView searchView;
    RecyclerView listshow;
    List<Item> productlists=new ArrayList<>();
    MainActivityAdapter adapter;
    ImageView iv_info;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_lista_guias, container,false);

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productlists.add(new Item("Crear Errtel",  R.drawable.guia_img));
        productlists.add(new Item("Nivel de un Errtel",  R.drawable.guia_img));
        productlists.add(new Item("Rank de un Errtel",  R.drawable.guia_img));
        productlists.add(new Item("Descomponer un Errtel",  R.drawable.guia_img));
        productlists.add(new Item("Crear Expansion Scroll of Radiance slot",  R.drawable.guia_img));
        productlists.add(new Item("Pentagramas", R.drawable.guia_img));

        iv_info = view.findViewById(R.id.iv_info);


        listshow = (RecyclerView)view.findViewById(R.id.listshow);
        listshow.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        listshow.setLayoutManager(linearLayoutManager);
        adapter=new MainActivityAdapter(productlists,getActivity());




        listshow.setAdapter(adapter);
        setHasOptionsMenu(true);


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);

        final MenuItem myActionMenuItem=menu.findItem(R.id.search);
        searchView=(SearchView) myActionMenuItem.getActionView();
        ((EditText) searchView.findViewById(androidx.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.colorPrimary));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Item> filtermodelist=filter(productlists,newText);
                adapter.setfilter(filtermodelist);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private List<Item> filter(List<Item> pl,String query)
    {
        query=query.toLowerCase();
        final List<Item> filteredModelist=new ArrayList<>();
        for(Item model:pl)
        {
            final  String text=model.getName().toLowerCase();
            if(text.startsWith(query))
            {
                filteredModelist.add(model) ;
            }
        }
        return  filteredModelist;
    }

    private void changeSearchViewTextColor(View view){
        if (view!=null){
            if (view instanceof TextView){
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            }else if (view instanceof ViewGroup){
                ViewGroup viewGroup=(ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount();i++){
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }

}
