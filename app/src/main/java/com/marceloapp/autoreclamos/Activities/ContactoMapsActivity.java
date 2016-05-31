package com.marceloapp.autoreclamos.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.marceloapp.autoreclamos.R;

public class ContactoMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public LatLng oficina;
    public String titleMaker;
    public TextView titleOficina;
    public TextView direccion;
    public TextView telefono;
    public Button btnLLamar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        direccion = (TextView)findViewById(R.id.direccion_contacto);
        telefono = (TextView)findViewById(R.id.telefono_contacto);
        titleOficina = (TextView)findViewById(R.id.title_oficina);

        direccion.setText(getIntent().getStringExtra("direccion"));
        telefono.setText(getIntent().getStringExtra("telefono"));
        titleOficina.setText("Oficina "+getIntent().getStringExtra("title"));
        btnLLamar = (Button) findViewById(R.id.btn_llamada_contacto);
        btnLLamar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialContactPhone("800102030");
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double lat = getIntent().getDoubleExtra("lat",0);
        Double lng = getIntent().getDoubleExtra("lng",0);
        oficina = new LatLng(lat,lng);
        titleMaker = getIntent().getStringExtra("title");

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(oficina).title(titleMaker));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(oficina));
        //Build camera position
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(oficina)
                .zoom(17).build();
        //Zoom in and animate the camera.
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
