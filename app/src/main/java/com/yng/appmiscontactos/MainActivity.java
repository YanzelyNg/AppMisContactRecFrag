package com.yng.appmiscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.yng.appmiscontactos.adapter.ContactoAdaptador;
import com.yng.appmiscontactos.adapter.PageAdapter;
import com.yng.appmiscontactos.fragment.PerfilFragment;
import com.yng.appmiscontactos.fragment.RecyclerViewFragment;
import com.yng.appmiscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        /*Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


*/

        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
 /*        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());
        }

       ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                String Toastms="On Item Click"+contactos.get(i).getNombre();
                Toast.makeText(getApplicationContext(), Toastms,Toast.LENGTH_LONG).show();
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                startActivity(intent);
                //Elimina la actividad, pero si presionan Back no podrá regresar a esta a menos que
                // verifique el botón de Back, ver código de Verificando botón de Back
                finish();
            }
        });*/
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacto);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
        //viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
    }


}