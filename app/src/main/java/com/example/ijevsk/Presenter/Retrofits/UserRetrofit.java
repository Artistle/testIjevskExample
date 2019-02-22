package com.example.ijevsk.Presenter.Retrofits;

import com.example.ijevsk.Model.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserRetrofit {
    @GET("testTask.json")
    Observable<UserModel.Example> register();
}
