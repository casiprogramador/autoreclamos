package com.marceloapp.autoreclamos.Models;

import com.marceloapp.autoreclamos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo on 30/4/2016.
 */
public class Reclamo {
    public String title;
    public String description;
    public int iconId;
    public Reclamo(String title, String description, int iconId){
        this.title = title;
        this.description = description;
        this.iconId = iconId;
    }
}

