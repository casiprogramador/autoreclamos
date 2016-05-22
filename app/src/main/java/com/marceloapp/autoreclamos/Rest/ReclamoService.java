package com.marceloapp.autoreclamos.Rest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Marcelo on 7/5/2016.
 */
public interface ReclamoService {
    @FormUrlEncoded
    @POST("/api/v1/reclamo")
    Call<ResponseHttp> createReclamo(@Field("tipo")String tipo,
                                     @Field("nombre")String nombre,
                                @Field("ci")String ci,
                                     @Field("phone")String phone,
                                @Field("marca")String marca,
                                @Field("modelo")String modelo,
                                @Field("anio")String anio,
                                @Field("placa")String placa,
                                     @Field("grua")String grua);
}
