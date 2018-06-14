
package com.davidlutta.galactic_ninja.cryptowatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quotes {

    @SerializedName("USD")
    @Expose
    private USD uSD;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quotes() {
    }

    /**
     * 
     * @param uSD
     */
    public Quotes(USD uSD) {
        super();
        this.uSD = uSD;
    }

    public USD getUSD() {
        return uSD;
    }

    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

}
