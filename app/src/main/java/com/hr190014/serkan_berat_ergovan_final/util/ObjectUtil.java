package com.hr190014.serkan_berat_ergovan_final.util;

import com.google.gson.Gson;
import com.hr190014.serkan_berat_ergovan_final.model.MeyveModel;

public class ObjectUtil {

    public  static String meyveToJsonString(MeyveModel meyveModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(meyveModel);
    }

    public  static MeyveModel jsonStringToMeyve(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,MeyveModel.class);
    }
}
