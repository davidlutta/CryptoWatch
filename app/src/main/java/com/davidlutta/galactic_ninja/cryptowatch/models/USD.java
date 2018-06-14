
package com.davidlutta.galactic_ninja.cryptowatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USD {

    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("volume_24h")
    @Expose
    private Integer volume24h;
    @SerializedName("market_cap")
    @Expose
    private Integer marketCap;
    @SerializedName("percent_change_1h")
    @Expose
    private Double percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    private Double percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    private Double percentChange7d;

    /**
     * No args constructor for use in serialization
     * 
     */
    public USD() {
    }

    /**
     * 
     * @param percentChange24h
     * @param marketCap
     * @param volume24h
     * @param price
     * @param percentChange7d
     * @param percentChange1h
     */
    public USD(Double price, Integer volume24h, Integer marketCap, Double percentChange1h, Double percentChange24h, Double percentChange7d) {
        super();
        this.price = price;
        this.volume24h = volume24h;
        this.marketCap = marketCap;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Integer volume24h) {
        this.volume24h = volume24h;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(Double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public Double getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(Double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public Double getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(Double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

}
