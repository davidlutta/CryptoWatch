
package com.davidlutta.galactic_ninja.cryptowatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Results {

    @SerializedName("id")
    @Expose
     Long id;
    @SerializedName("name")
    @Expose
     String name;
    @SerializedName("symbol")
    @Expose
     String symbol;
    @SerializedName("website_slug")
    @Expose
     String websiteSlug;
    @SerializedName("rank")
    @Expose
     Long rank;
    @SerializedName("circulating_supply")
    @Expose
     Long circulatingSupply;
    @SerializedName("total_supply")
    @Expose
     Long totalSupply;
    @SerializedName("max_supply")
    @Expose
     Long maxSupply;
    @SerializedName("quotes")
    @Expose
     Quotes quotes;
    @SerializedName("last_updated")
    @Expose
     Long lastUpdated;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param id
     * @param maxSupply
     * @param rank
     * @param circulatingSupply
     * @param quotes
     * @param symbol
     * @param name
     * @param websiteSlug
     * @param lastUpdated
     * @param totalSupply
     */
    public Results(Long id, String name, String symbol, String websiteSlug, Long rank, Long circulatingSupply, Long totalSupply, Long maxSupply, Quotes quotes, Long lastUpdated) {
        super();
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.websiteSlug = websiteSlug;
        this.rank = rank;
        this.circulatingSupply = circulatingSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.quotes = quotes;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWebsiteSlug() {
        return websiteSlug;
    }

    public void setWebsiteSlug(String websiteSlug) {
        this.websiteSlug = websiteSlug;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Long getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Long totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Long getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Long maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
