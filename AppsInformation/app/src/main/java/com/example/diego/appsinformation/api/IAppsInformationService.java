package com.example.diego.appsinformation.api;

import com.example.diego.appsinformation.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Diego on 24/06/2016.
 */
public interface IAppsInformationService {
    @GET("us/rss/topfreeapplications/limit=30/json")
    Call<Example> getAppsInformation();

}
