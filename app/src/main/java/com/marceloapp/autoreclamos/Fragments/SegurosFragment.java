package com.marceloapp.autoreclamos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marceloapp.autoreclamos.Adapters.SeguroAdapter;
import com.marceloapp.autoreclamos.Models.Seguro;
import com.marceloapp.autoreclamos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegurosFragment extends Fragment {

    private List<Seguro> seguros;
    private RecyclerView recyclerView;

    public SegurosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentActivity c = getActivity();
        View view = inflater.inflate(R.layout.fragment_seguros, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RVseguros);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        seguros = new ArrayList<>();
        seguros.add(new Seguro("Seguro de Vida ","Resguardo frente a una posible situación de apremios económicos, para su familia en caso de su fallecimiento.",R.drawable.icon_vida_seguro));
        seguros.add(new Seguro("Seguro Patrimonial","Reparar la pérdida que un asegurado puede sufrir en su patrimonio como consecuencia de un siniestro",R.drawable.icon_patrimonio_seguro));
        seguros.add(new Seguro("Seguro para Viajes","Las personas que vayan a desplazarse por cualquier motivo estar protegidas frente a percances relacionados con su salud, accidentes personales, equipaje, demoras o cancelación, entre otros",R.drawable.icon_viaje_seguro));
        seguros.add(new Seguro("Seguro de Automoviles","Cubre los riesgos creados por la conducción de automóviles en caso de causar un accidente",R.drawable.icon_auto_seguro));
        SeguroAdapter adapter = new SeguroAdapter(seguros);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
