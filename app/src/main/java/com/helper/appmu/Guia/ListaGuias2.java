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

public class ListaGuias2 extends Fragment {
    ListView lista;
    SearchView searchView;
    RecyclerView listshow;
    List<Item> productlists=new ArrayList<>();
    MainActivityAdapter adapter;
    ImageView iv_info;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_lista_guias2, container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productlists.add(new Item("Wings Level 3",R.drawable.guia_img));
        productlists.add(new Item("Condor Feather",R.drawable.guia_img));
        productlists.add(new Item("Opciones 380", R.drawable.guia_img));
        productlists.add(new Item("Armas Socket",  R.drawable.guia_img));
        productlists.add(new Item("Wings Level 1", R.drawable.guia_img));
        productlists.add(new Item("Wings Level 2",  R.drawable.guia_img));
        productlists.add(new Item("Chaos Weapon",  R.drawable.guia_img));
        productlists.add(new Item("Monster Wings 2.5", R.drawable.guia_img));
        productlists.add(new Item("Horn of Fenrir Blue",R.drawable.guia_img));
        productlists.add(new Item("Horn of Fenrir Black", R.drawable.guia_img));
        productlists.add(new Item("Horn of Fenrir Red", R.drawable.guia_img));
        productlists.add(new Item("Broken Horn", R.drawable.guia_img));
        productlists.add(new Item("Fragment of Horn", R.drawable.guia_img));
        productlists.add(new Item("Wings Level 4", R.drawable.guia_img));
        productlists.add(new Item("Blessed Divine of Archangel",  R.drawable.guia_img));
        productlists.add(new Item("Ancient Hero Soul",  R.drawable.guia_img));
        productlists.add(new Item("Set Item Bloodangel", R.drawable.guia_img));
        productlists.add(new Item("Set Item Darkangel",  R.drawable.guia_img));
        productlists.add(new Item("Set Item Holyangel",  R.drawable.guia_img));
        productlists.add(new Item("Magic Stone",  R.drawable.guia_img));
        productlists.add(new Item("Garuda Feather",  R.drawable.guia_img));
        productlists.add(new Item("Set Item Awakening", R.drawable.guia_img));
        productlists.add(new Item("Weapons Darkangel",  R.drawable.guia_img));
        productlists.add(new Item("Weapons Holyangel",  R.drawable.guia_img));
        productlists.add(new Item("Weapons Awakening",  R.drawable.guia_img));


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
