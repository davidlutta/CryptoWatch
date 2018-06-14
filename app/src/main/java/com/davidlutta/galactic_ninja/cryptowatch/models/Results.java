
package com.davidlutta.galactic_ninja.cryptowatch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("website_slug")
    @Expose
    private String websiteSlug;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("circulating_supply")
    @Expose
    private Integer circulatingSupply;
    @SerializedName("total_supply")
    @Expose
    private Integer totalSupply;
    @SerializedName("max_supply")
    @Expose
    private Integer maxSupply;
    @SerializedName("quotes")
    @Expose
    private Quotes quotes;
    @SerializedName("last_updated")
    @Expose
    private Integer lastUpdated;

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
    public Results(Integer id, String name, String symbol, String websiteSlug, Integer rank, Integer circulatingSupply, Integer totalSupply, Integer maxSupply, Quotes quotes, Integer lastUpdated) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Integer circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Integer getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Integer totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Integer getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Integer maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    public Integer getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
