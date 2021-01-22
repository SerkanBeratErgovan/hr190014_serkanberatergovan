package com.hr190014.serkan_berat_ergovan_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190014.serkan_berat_ergovan_final.R;
import com.hr190014.serkan_berat_ergovan_final.model.MeyveModel;
import com.hr190014.serkan_berat_ergovan_final.util.GlideUtil;

import java.util.List;

public class MeyveAdaptor  extends RecyclerView.Adapter<MeyveViewHolder> {

    List<MeyveModel> meyveler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }

    public MeyveAdaptor(List<MeyveModel> meyveler, Context context,OnItemClickListener listener) {
        this.meyveler = meyveler;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MeyveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_meyve,parent,false);
        return new MeyveViewHolder(itemView,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull MeyveViewHolder viewHolder, int position) {

        viewHolder.txtMeyveAdi.setText(meyveler.get(position).getMeyveAdi());
        viewHolder.txtVitamin.setText(meyveler.get(position).getVitamin());
        GlideUtil.resmiIndiripGoster(context,meyveler.get(position).getLogoUrl(),viewHolder.imgMeyveLogo);

    }
    @Override
    public int getItemCount() {
        return meyveler.size();
    }
}