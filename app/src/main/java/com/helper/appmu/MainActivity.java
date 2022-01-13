package com.helper.appmu;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.helper.appmu.Guia.Guias;

import androidx.fragment.app.FragmentManager;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;


import com.helper.appmu.Adapter.CustomExpandibleListAdapter;
import com.helper.appmu.Donaciones.Hcoin;
import com.helper.appmu.Donaciones.VIP;
import com.helper.appmu.Helper.FragmentNavigationManager;
import com.helper.appmu.Interface.NavigationManager;
import com.helper.appmu.ListMuDona.ListaMu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabottom;
    SharedPreferences sharedPreferences;
    Context contexto;
    ImageButton btn_Inicio;
    Button btn_fb,btn_wp,btn_GUIAS;
    ArrayAdapter<String> adapter;

    private AdView mAdView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ExpandableListView expandableListView;
    private List<String> listTitle;
    private Map<String,List<String>> listChild;
    private NavigationManager navigationManager;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoActionBar);
        Themes();
        setContentView(R.layout.activity_main);
        btn();

        ActionBar actionBar = getActionBar();

contexto =this;

        //Int view ni idea porque lo escribi
        mDrawerLayout = findViewById(R.id.drawer_layout);
        String mActivityTitle = getTitle().toString();
        expandableListView = findViewById(R.id.navList);
        navigationManager = FragmentNavigationManager.getmInstance(this);

        initItem();
        View listHeaderView = getLayoutInflater().inflate(R.layout.new_header,null,false);
        expandableListView.addHeaderView(listHeaderView);

        genData();
        addDrawerItem();
        setupDrawer();

        setTheme(R.style.NoActionBar);
        btn_Inicio = findViewById(R.id.btn_Inicio);

        btn_Inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });



        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        if (savedInstanceState == null)
            selectFirstItemAsDefault();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("AYUDA MU");



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);

    }

    private void selectFirstItemAsDefault() {
        if (navigationManager !=null)
        {
            String firstItem = listTitle.get(0);
            navigationManager.showFragment(firstItem);
            Objects.requireNonNull(getSupportActionBar()).setTitle(firstItem);

        }
    }

    private void btn(){
        ImageButton btn_pag = findViewById(R.id.btn_pag);


        btn_wp = findViewById(R.id.btn_wp);
        btn_fb = findViewById(R.id.btn_fb);
        btn_GUIAS = findViewById(R.id.btn_GUIAS);
        fabottom = (FloatingActionButton)findViewById(R.id.fabottom);





        btn_pag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //El brindamos el dato necesario a Uri
                Uri uriUrl = Uri.parse("http://www.heroesmu.com/usuario.htm");
              //  Uri uriUrl = Uri.parse("http://tuservermu.com.ve/");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });

        btn_fb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //El brindamos el dato necesario a Uri
                Uri uriUrl = Uri.parse("https://www.facebook.com/HeroesNetworks.Oficial/");
                //Especificamos la accion a realizar con el ACTION_VIEW
                //para que elija lo mas razonable
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
        fabottom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(contexto, ViewTop.class);
                contexto.startActivity(intent);
            }
        });
        btn_wp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               /*  Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+5214521767269"));
                startActivity(intent); */
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new ListaMu()).addToBackStack(null).commit();

            }
        });
        btn_GUIAS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        new Guias()).addToBackStack(null).commit();


            }
        });

    }


    private void Themes(){

    sharedPreferences = getSharedPreferences("VALUES",MODE_PRIVATE);
    int theme = sharedPreferences.getInt("THEME",1);

    switch (theme){
        case 1: setTheme(R.style.AppTheme);

            break;
        case 2: setTheme(R.style.NoActionBar);
            break;
    }


}

    private void addDrawerItem() {
        ExpandableListAdapter adapter = new CustomExpandibleListAdapter(this, listTitle, listChild);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener(){
            @Override
            public void onGroupExpand(int groupPosition){
                Objects.requireNonNull(getSupportActionBar()).setTitle(listTitle.get(groupPosition));
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Objects.requireNonNull(getSupportActionBar()).setTitle("AYUDA MU");
            }
        });




        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String selectedItem = ((List) (Objects.requireNonNull(listChild.get(listTitle.get(groupPosition)))))
                        .get(childPosition).toString();
                Objects.requireNonNull(getSupportActionBar()).setTitle(selectedItem);

                if(Objects.equals(selectedItem, "LISTA DE MU!")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            new ListaMu()).addToBackStack(null).commit();
                }
                else
               if(Objects.equals(selectedItem, "TOP MU")){
                Intent intent = new Intent(contexto, ViewTop.class);
                contexto.startActivity(intent);

                }
                else
                    if(Objects.equals(selectedItem, "GUIAS MU OFFLINE")){
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                               new Guias()).addToBackStack(null).commit();

                    }

                        else
                            if(Objects.equals(selectedItem, "Acerca de D.Ñ.")){

                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        new Email()).addToBackStack(null).commit();
                    }
                        else
                            if(Objects.equals(selectedItem, "VIP")){

                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        new VIP()).addToBackStack(null).commit();
                            }
                            else
                                if(Objects.equals(selectedItem, "HCOIN")){
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        new Hcoin()).addToBackStack(null).commit();
                            }
                            else
                                if(Objects.equals(selectedItem, "EMAIL PARA DONAR")){
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        new EmailD()).addToBackStack(null).commit();
                            }
                            else
                                if(Objects.equals(selectedItem, "PAG DE PROMOCION")){
                                    try{
                                        //El brindamos el dato necesario a Uri
                                        Uri uriUrl = Uri.parse("http://www.heroes-networks.com/heroes-networks/heroes-networks/donaciones/promociones");
                                        //Especificamos la accion a realizar con el ACTION_VIEW
                                        //para que elija lo mas razonable
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(intent);
                                    }
                                    catch (Exception error){
                                        Log.e("UPDATE error", error.getMessage());
                                    }
                            }
                            else

                throw new IllegalArgumentException("Fragmento no soportado");

                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void genData() {
        //LISTA DEL MENU LATERAL PARA ACCEDER A GUIAAS Y DONACIONES
        List<String> title = Arrays.asList( "•GUIA","•DONACION A HeroesMu","•SRV MU");
        List<String> childitem = Arrays.asList("LISTA DE MU!","TOP MU");
        List<String> childitem2 = Arrays.asList("GUIAS MU OFFLINE","Acerca de D.Ñ.");
        List<String> childitem3 = Arrays.asList("VIP","HCOIN","PAG DE PROMOCION","EMAIL PARA DONAR");


        listChild = new TreeMap<>();

         listChild.put(title.get(2),childitem);
        listChild.put(title.get(1),childitem3);
        listChild.put(title.get(0),childitem2);




        listTitle = new ArrayList<>(listChild.keySet());
    }

    private void initItem() {
        String[] items = new String[]{ "•GUIA","•DONACION A HeroesMu","•SRV MU"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);

    }


}
