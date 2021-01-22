package com.hr190014.serkan_berat_ergovan_final.network;

import com.hr190014.serkan_berat_ergovan_final.model.MeyveModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("MeyvelerinYararlariApi.json")
    Observable<List<MeyveModel>> meyveleriGetir();
}