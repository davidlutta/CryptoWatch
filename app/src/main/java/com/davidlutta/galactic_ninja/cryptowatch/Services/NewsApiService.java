package com.davidlutta.galactic_ninja.cryptowatch.Services;

import android.util.Log;

import com.davidlutta.galactic_ninja.cryptowatch.Constants;
import com.davidlutta.galactic_ninja.cryptowatch.models.Articles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsApiService {
    private static OkHttpClient client = new OkHttpClient();

    public static void loadArticles(Callback callback){
        HttpUrl.Builder builder = HttpUrl.parse(Constants.NEWS_BASE_URL).newBuilder();
        String url = builder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue((okhttp3.Callback) callback);
    }

    public ArrayList<Articles> processArticles(Response response) throws IOException{
        ArrayList<Articles> articles = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject newsJSON = new JSONObject(jsonData);
                JSONArray  resultsJson = newsJSON.getJSONArray("articles");
                Gson gson = new GsonBuilder().create();

                Type collectionType = new TypeToken<List<Articles>>(){}.getType();
                articles = gson.fromJson(resultsJson.toString(),collectionType);
              }

        } catch (NullPointerException | JSONException | IOException e){
            e.printStackTrace();
        }

        return articles;
    }

}
