package com.hr190014.serkan_berat_ergovan_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.hr190014.serkan_berat_ergovan_final.R;
import com.hr190014.serkan_berat_ergovan_final.adaptor.MeyveAdaptor;
import com.hr190014.serkan_berat_ergovan_final.model.MeyveModel;
import com.hr190014.serkan_berat_ergovan_final.network.Service;
import com.hr190014.serkan_berat_ergovan_final.util.Constants;
import com.hr190014.serkan_berat_ergovan_final.util.ObjectUtil;
import com.hr190014.serkan_berat_ergovan_final.util.ProgressUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ProgressUtil.ConnectionCheck(ListActivity.this);
        init();

    }
    private  void  init()
    {
        meyveleriGetir();
    }
    void  meyveleriGetir()
    {
        new Service().getServiceApi().meyveleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MeyveModel>>() {

                    List<MeyveModel> meyveler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<MeyveModel> meyveList) {
                        Log.e("RETROFIT","onNext : ");
                        meyveler=meyveList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(meyveler.size()>0) {

                            initRecycleView(meyveler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<MeyveModel> meyveList)
    {
        recyclerView =findViewById(R.id.rcvMeyveler);
        MeyveAdaptor meyveAdaptor =new MeyveAdaptor(meyveList, getApplicationContext(), new MeyveAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                MeyveModel tiklananMeyve =meyveList.get(position);
                Toast.makeText(getApplicationContext(), (getResources().getString(R.string.tiklanan_meyve_basligi)) + tiklananMeyve.getMeyveAdi(), Toast.LENGTH_SHORT).show();
                openNextActivity(tiklananMeyve);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(meyveAdaptor);
    }

    private void openNextActivity(MeyveModel tiklananMeyve){

        Intent secondActivityIntent=new Intent(getApplicationContext(),MeyveDetailActivity.class);
        String tiklananMeyveString = ObjectUtil.meyveToJsonString(tiklananMeyve);
        secondActivityIntent.putExtra(Constants.TIKLANAN_MEYVE_TASIMANIN_BASLIGI,tiklananMeyveString);
        startActivity(secondActivityIntent);
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
        builder.setMessage(getResources().getString(R.string.exit_message));
        builder.setCancelable(true);
        builder.setNegativeButton(getResources().getString(R.string.negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

