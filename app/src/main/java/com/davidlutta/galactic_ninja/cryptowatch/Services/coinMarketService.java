package com.davidlutta.galactic_ninja.cryptowatch.Services;

import android.util.Log;

import com.davidlutta.galactic_ninja.cryptowatch.Constants;
import com.davidlutta.galactic_ninja.cryptowatch.models.Results;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class coinMarketService {
    private static OkHttpClient client = new OkHttpClient();

    public static void loadResults(Callback callback) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue((okhttp3.Callback) callback);
    }

    public ArrayList<Results> processResults(Response response) throws IOException {
        ArrayList<Results> currencies =new ArrayList<>();

        try {
            String jsonData = response.body().string();
            Gson gson = new GsonBuilder().create();
            if (response.isSuccessful()){
                JSONObject coinMarketJSON = new JSONObject(jsonData);
                JSONObject dataJSON = coinMarketJSON.getJSONObject("data");
                for (Iterator<String> data = dataJSON.keys(); data.hasNext();) {
                    Object key = data.next();
                    Results results = gson.fromJson(dataJSON.getJSONObject(key.toString()).toString(), Results.class);
                    currencies.add(results);
                }
            }
        } catch (NullPointerException | JSONException | IOException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}