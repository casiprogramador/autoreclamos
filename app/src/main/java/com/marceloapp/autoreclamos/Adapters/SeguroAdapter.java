package com.marceloapp.autoreclamos.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marceloapp.autoreclamos.Activities.FormReclamoActivity;
import com.marceloapp.autoreclamos.Fragments.DialogSeguroFragment;
import com.marceloapp.autoreclamos.Models.Seguro;
import com.marceloapp.autoreclamos.R;

import java.util.List;

/**
 * Created by Marcelo on 21/5/2016.
 */
public class SeguroAdapter extends RecyclerView.Adapter <SeguroAdapter.SeguroViewHolder>{

    List<Seguro> seguro;
    public static Context context;

    public SeguroAdapter(List<Seguro> seguro,Context context){
        this.seguro = seguro;
        this.context = context;
    }
    @Override
    public SeguroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_itemseguro, parent, false);
        SeguroViewHolder rvh = new SeguroViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(SeguroViewHolder holder, int position) {
        holder.seguroTitle.setText(seguro.get(position).title);
        holder.seguroDescription.setText(seguro.get(position).description);
        holder.seguroIcon.setImageResource(seguro.get(position).iconId);
    }

    @Override
    public int getItemCount() {
        return seguro.size();
    }

    public static class SeguroViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView seguroTitle;
        TextView seguroDescription;
        ImageView seguroIcon;

        public SeguroViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cvseguro);
            seguroTitle = (TextView)itemView.findViewById(R.id.seguro_title);
            seguroDescription = (TextView)itemView.findViewById(R.id.seguro_description);
            seguroIcon = (ImageView)itemView.findViewById(R.id.seguro_icon);

            cv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    android.app.FragmentManager fm = ((Activity) context).getFragmentManager();
                    DialogSeguroFragment seguroDialog = new DialogSeguroFragment();
                    seguroDialog.show(fm,"Cotizar Seguro");
                }
            });
        }
    }
}
