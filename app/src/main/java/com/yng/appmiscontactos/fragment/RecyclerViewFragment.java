package com.yng.appmiscontactos.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yng.appmiscontactos.R;
import com.yng.appmiscontactos.adapter.ContactoAdaptador;
import com.yng.appmiscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    public ContactoAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        /*GridLayoutManager glm = new GridLayoutManager(this, 2);
        listaContactos.setLayoutManager(glm);*/

        inicializarListaContactos();
        inicializarAdaptador();
        //return super.onCreateView(inflater, container, savedInstanceState);

        return v;
    }


    public void inicializarAdaptador()
    {
        adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.candy_icon,"Yanzely Ng", "77711111", "yng@gmail.com"));
        contactos.add(new Contacto(R.drawable.forest_mushrooms,"Faustino Botacio", "22211111", "fbota@gmail.com"));
        contactos.add(new Contacto(R.drawable.shockray,"Diana Ng", "33311111", "dianang@gmail.com"));
        contactos.add(new Contacto(R.drawable.shockray_bonus, "Lisbeth Ng", "44411111", "lisng@gmail.com"));
        contactos.add(new Contacto(R.drawable.yammi_banana,"Iluminada Ng", "55511111", "ilung@gmail.com"));

    }
}
