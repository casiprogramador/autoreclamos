package com.marceloapp.autoreclamos.Fragments;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marceloapp.autoreclamos.R;
import com.marceloapp.autoreclamos.Rest.DownloadService;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiciosFragment extends Fragment {

    private static final String TAG = "###AUTORECLAMO";
    Button btnDescargarSeguroVida;
    Button btnDescargarSeguroArrendamiento;
    Button btnDescargarDenunciaSiniestro;
    Button btnDescargargastosMedicos;
    private ProgressDialog dialog;

    public ServiciosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_servicios, container, false);
        btnDescargarSeguroVida = (Button)view.findViewById(R.id.descarga_segurovida);
        btnDescargarSeguroArrendamiento = (Button)view.findViewById(R.id.descarga_arrendamiento);
        btnDescargarDenunciaSiniestro = (Button)view.findViewById(R.id.descarga_siniestroauto);
        btnDescargargastosMedicos  = (Button)view.findViewById(R.id.descarga_gastosmedicos);

        btnDescargarSeguroVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadFileAsyncTask downloadFileAsyncTask = new DownloadFileAsyncTask(
                        "https://autoreclamo-server-pmarce.c9users.io/",
                        "https://autoreclamo-server-pmarce.c9users.io//api/v1/descargar/seguro_vida",
                        "seguro_vida");
                downloadFileAsyncTask.execute();
            }
        });
        btnDescargarSeguroArrendamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadFileAsyncTask downloadFileAsyncTask = new DownloadFileAsyncTask(
                        "https://autoreclamo-server-pmarce.c9users.io/",
                        "https://autoreclamo-server-pmarce.c9users.io//api/v1/descargar/seguro_arrendamiento",
                        "seguro_arrendamiento");
                downloadFileAsyncTask.execute();
            }
        });
        btnDescargarDenunciaSiniestro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadFileAsyncTask downloadFileAsyncTask = new DownloadFileAsyncTask(
                        "https://autoreclamo-server-pmarce.c9users.io/",
                        "https://autoreclamo-server-pmarce.c9users.io//api/v1/descargar/denuncia_siniestro",
                        "denuncia_siniestro");
                downloadFileAsyncTask.execute();
            }
        });
        btnDescargargastosMedicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadFileAsyncTask downloadFileAsyncTask = new DownloadFileAsyncTask(
                        "https://autoreclamo-server-pmarce.c9users.io/",
                        "https://autoreclamo-server-pmarce.c9users.io/6+/api/v1/descargar/gastos_medicos",
                        "gastos_medicos");
                downloadFileAsyncTask.execute();
            }
        });

        return view;
    }

    public class DownloadFileAsyncTask extends AsyncTask<Void, Void, Void> {

        String fileNameDownload;
        String url;
        String urlDownload;
        File imageRoot = Environment.getExternalStorageDirectory();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date now = new Date();
        String currentDateTimeString = formatter.format(now);


        private static final String TAG = "###AUTORECLAMO";


        public DownloadFileAsyncTask(String url,String urlDownload,String fileName){
            this.url = url;
            this.urlDownload = urlDownload;
            this.fileNameDownload = fileName;
            dialog = new ProgressDialog(getActivity());
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Descargando archivo....");
            dialog.show();
        }


        @Override
        protected Void doInBackground(Void... params) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .build();
            DownloadService service = retrofit.create(DownloadService.class);
            service.getFile(urlDownload).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String filename = fileNameDownload+"_"+currentDateTimeString+".pdf";
                    try {
                        File file = new File(imageRoot, filename);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            IOUtils.write(response.body().bytes(), fileOutputStream);
                        } catch (IOException e) {
                            Log.e(TAG, "IO Exception: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    catch (Exception ex){
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                    // TODO: show error message
                }
            });
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

        public void descargaArchivo(String url, final String file_name){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(client)
                    .build();
            DownloadService service = retrofit.create(DownloadService.class);
            service.getFile("https://autoreclamo-server-pmarce.c9users.io//api/v1/descargar/seguro_vida").enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        //File path = Environment.getExternalStorageDirectory();
                        //File file = new File(path, "seguro_vida.pdf");
                        //FileOutputStream fileOutputStream = new FileOutputStream(file);
                        //IOUtils.write(response.body().bytes(), fileOutputStream);

                    }
                    catch (Exception ex){
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                    // TODO: show error message
                }
            });
        }
    }

}
