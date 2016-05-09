package com.marceloapp.autoreclamos.Rest;

/**
 * Created by Marcelo on 7/5/2016.
 */
public class Reclamo {
    public String nombre;
    public String ci;
    public String modelo;
    public String marca;
    public String anio;
    public String placa;

    public Reclamo(String nombre,String ci,String modelo,String marca,String anio,String placa){
        this.nombre = nombre;
        this.ci = ci;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.placa = placa;
    }

}
