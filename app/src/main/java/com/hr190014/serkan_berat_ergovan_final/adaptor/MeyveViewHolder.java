package com.hr190014.serkan_berat_ergovan_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190014.serkan_berat_ergovan_final.R;

import org.w3c.dom.Text;

public class MeyveViewHolder  extends RecyclerView.ViewHolder {

    ImageView imgMeyveLogo;
    TextView txtMeyveAdi;
    TextView txtVitamin;

    public MeyveViewHolder(@NonNull View cardView, MeyveAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgMeyveLogo =cardView.findViewById(R.id.imgMeyveLogo);
        txtMeyveAdi =cardView.findViewById(R.id.txtMeyveAdi);
        txtVitamin =cardView.findViewById(R.id.txtVitamin);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClik(getAdapterPosition());
            }

        });
    }
}