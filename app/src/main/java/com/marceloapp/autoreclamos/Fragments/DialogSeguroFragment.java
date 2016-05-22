package com.marceloapp.autoreclamos.Fragments;


import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marceloapp.autoreclamos.R;

public class DialogSeguroFragment extends DialogFragment {
    Button btnCancelar;
    Button btnCotizar;

    public DialogSeguroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dialog_seguro, container, false);
        getDialog().setTitle("Cotizar seguro");
        btnCotizar = (Button)rootView.findViewById(R.id.btn_seguro_contactarse);
        btnCotizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialContactPhone("800102030");
            }
        });
        btnCancelar = (Button)rootView.findViewById(R.id.btn_seguro_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }

}
