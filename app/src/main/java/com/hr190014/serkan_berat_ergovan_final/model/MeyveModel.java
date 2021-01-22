package com.hr190014.serkan_berat_ergovan_final.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MeyveModel {

    @SerializedName("MeyveAdi")
    @Expose
    private String meyveAdi;
    @SerializedName("Vitamin")
    @Expose
    private String vitamin;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("MeyveninOzellikleriUrl")
    @Expose
    private String meyveninOzellikleriUrl;

    public String getMeyveAdi() {
        return meyveAdi;
    }

    public void setMeyveAdi(String meyveAdi) {
        this.meyveAdi = meyveAdi;
    }

    public String getVitamin() {
        return vitamin;
    }

    public void setVitamin(String vitamin) {
        this.vitamin = vitamin;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getMeyveninOzellikleriUrl() {
        return meyveninOzellikleriUrl;
    }

    public void setMeyveninOzellikleriUrl(String meyveninOzellikleriUrl) {
        this.meyveninOzellikleriUrl = meyveninOzellikleriUrl;
    }

}