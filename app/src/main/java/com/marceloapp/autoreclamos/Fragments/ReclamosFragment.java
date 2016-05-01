package com.marceloapp.autoreclamos.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marceloapp.autoreclamos.Adapters.ReclamosAdapter;
import com.marceloapp.autoreclamos.Models.Reclamo;
import com.marceloapp.autoreclamos.R;

import java.util.ArrayList;
import java.util.List;

public class ReclamosFragment extends Fragment {


    private List<Reclamo> reclamos;
    private RecyclerView recyclerView;

    public ReclamosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentActivity c = getActivity();
        View view = inflater.inflate(R.layout.fragment_reclamos, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RVreclamos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);

        reclamos = new ArrayList<>();
        reclamos.add(new Reclamo("Falla Mecanica","En caso de alguna falla mecanica o auxilio de grua",R.drawable.icon_car));
        reclamos.add(new Reclamo("Accidente ","En caso de accidente con danos materiales",R.drawable.icon_car));
        reclamos.add(new Reclamo("Robo","En caso de robo parcial o total",R.drawable.icon_car));

        ReclamosAdapter adapter = new ReclamosAdapter(reclamos);
        recyclerView.setAdapter(adapter);

        //initializeData();
        //initializeAdapter();

        return view;
    }

    private void initializeData(){
        reclamos = new ArrayList<>();
        reclamos.add(new Reclamo("Titulo Reclamo 1","Descripcion Reclamo 1",R.mipmap.ic_launcher));
        reclamos.add(new Reclamo("Titulo Reclamo 2","Descripcion Reclamo 2",R.mipmap.ic_launcher));
        reclamos.add(new Reclamo("Titulo Reclamo 3","Descripcion Reclamo 3",R.mipmap.ic_launcher));
    }

    private void initializeAdapter(){
        ReclamosAdapter adapter = new ReclamosAdapter(reclamos);
        recyclerView.setAdapter(adapter);
    }
}
