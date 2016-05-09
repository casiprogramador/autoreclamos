package com.marceloapp.autoreclamos.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.marceloapp.autoreclamos.R;
import com.marceloapp.autoreclamos.Rest.Reclamo;
import com.marceloapp.autoreclamos.Rest.ReclamoService;
import com.marceloapp.autoreclamos.Rest.ResponseHttp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * Created by Marcelo on 7/5/2016.
 */
public class FormReclamoActivity extends AppCompatActivity{
    Toolbar toolbar;
    EditText marca;
    EditText modelo;
    EditText anio;
    EditText placa;
    Button btnReclamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reclamo);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        marca = (EditText)findViewById(R.id.input_marca);
        modelo = (EditText)findViewById(R.id.input_modelo);
        anio = (EditText)findViewById(R.id.input_anio);
        placa = (EditText)findViewById(R.id.input_placa);
        btnReclamo = (Button)findViewById(R.id.btn_save_reclamo);
        btnReclamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("user_date", Context.MODE_PRIVATE);

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://autoreclamo-server-pmarce.c9users.io/")
                        .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
                        .build();

                ReclamoService service = retrofit.create(ReclamoService.class);
                Call<ResponseHttp> call = service.createReclamo(
                        getIntent().getStringExtra("tipo_reclamo"),
                        preferences.getString("name_user",""),
                        preferences.getString("ci_user",""),
                        marca.getText().toString(),
                        modelo.getText().toString(),
                        anio.getText().toString(),
                        placa.getText().toString());
                call.enqueue(new Callback<ResponseHttp>() {
                    @Override
                    public void onResponse(Call<ResponseHttp> call, Response<ResponseHttp> response) {
                        Log.i("respuesta", String.valueOf(response));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseHttp> call, Throwable t) {
                        finish();
                    }
                });

            }
        });

    }

}
