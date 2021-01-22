package com.hr190014.serkan_berat_ergovan_final.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190014.serkan_berat_ergovan_final.R;
import com.hr190014.serkan_berat_ergovan_final.model.MeyveModel;
import com.hr190014.serkan_berat_ergovan_final.util.Constants;
import com.hr190014.serkan_berat_ergovan_final.util.GlideUtil;
import com.hr190014.serkan_berat_ergovan_final.util.ObjectUtil;

public class MeyveDetailActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    TextView txtBaslik2;
    TextView txtDetay2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyve_detail);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void init(){
        String tasinanMeyveString =getIntent().getStringExtra(Constants.TIKLANAN_MEYVE_TASIMANIN_BASLIGI);
        MeyveModel meyveModel = ObjectUtil.jsonStringToMeyve(tasinanMeyveString);

        imgKapak =findViewById(R.id.imgKapak);
        txtBaslik =findViewById(R.id.txtBaslik);
        txtDetay =findViewById(R.id.txtDetay);
        txtBaslik2 =findViewById(R.id.txtBaslik2);
        txtDetay2 =findViewById(R.id.txtDetay2);

        txtBaslik.setText(meyveModel.getMeyveAdi());
        txtDetay.setText(Html.fromHtml(meyveModel.getAciklama(),Html.FROM_HTML_MODE_COMPACT));
        txtBaslik2.setText(meyveModel.getMeyveAdi() +" " +(getResources().getString(R.string.baslik_fayda)));
        txtDetay2.setText(Html.fromHtml(meyveModel.getMeyveninOzellikleriUrl(),Html.FROM_HTML_MODE_COMPACT));

        GlideUtil.resmiIndiripGoster(getApplicationContext(),meyveModel.getKapakFotoUrl(),imgKapak);

    }
}