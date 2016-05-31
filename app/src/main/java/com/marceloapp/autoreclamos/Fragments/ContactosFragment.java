package com.marceloapp.autoreclamos.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marceloapp.autoreclamos.Activities.ContactoMapsActivity;
import com.marceloapp.autoreclamos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactosFragment extends Fragment {

    Button btnLaPaz;
    Button btnCochabamba;
    Button btnSantacruz;
    public ContactosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contactos, container, false);
        btnLaPaz = (Button)view.findViewById(R.id.lapaz);
        btnLaPaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maps = new Intent(getActivity(), ContactoMapsActivity.class);
                maps.putExtra("lat",-16.5077743);
                maps.putExtra("lng",-68.1268885);
                maps.putExtra("title","La Paz");
                maps.putExtra("telefono","Telefono: 2482154");
                maps.putExtra("direccion","Direccion: Av arce esq belisario salinas nro 195");
                startActivity(maps);
            }
        });

        btnCochabamba = (Button)view.findViewById(R.id.cochabamba);
        btnCochabamba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maps = new Intent(getActivity(), ContactoMapsActivity.class);
                maps.putExtra("lat",-17.382112);
                maps.putExtra("lng",-66.158004);
                maps.putExtra("title","Cochabamba");
                maps.putExtra("telefono","Telefono: 4561265-451265");
                maps.putExtra("direccion","Direccion: Av. Ramon Rivero esq Lanza nro 2343");
                startActivity(maps);
            }
        });
        btnSantacruz = (Button)view.findViewById(R.id.santacruz);
        btnSantacruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maps = new Intent(getActivity(), ContactoMapsActivity.class);
                maps.putExtra("lat",-17.807241);
                maps.putExtra("lng", -63.141492);
                maps.putExtra("title","Santa Cruz");
                maps.putExtra("telefono","Telefono: 3925645-3125678");
                maps.putExtra("direccion","Direccion: Av. 6 de febrero esq avenida sudamericana y el trillo nro 458");
                startActivity(maps);
            }
        });
        return view;
    }

}
