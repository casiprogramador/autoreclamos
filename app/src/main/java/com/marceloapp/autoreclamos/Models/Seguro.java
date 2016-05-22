package com.marceloapp.autoreclamos.Models;

/**
 * Created by Marcelo on 21/5/2016.
 */
public class Seguro {
    public String title;
    public String description;
    public int iconId;
    public Seguro(String title, String description, int iconId){
        this.title = title;
        this.description = description;
        this.iconId = iconId;
    }
}
