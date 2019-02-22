package com.example.ijevsk.Presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ijevsk.Model.UserModel;
import com.example.ijevsk.Presenter.Adapters.UserAdapter;
import com.example.ijevsk.RetrofitDI.RetrofitDI;
import com.example.ijevsk.View;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class Presenter extends MvpPresenter<View> {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private UserAdapter adapter;
    private List<UserModel.Response> infoListModels;

    @Inject
    RetrofitDI retrofitDI = new RetrofitDI();

    public void loadJson(){

        compositeDisposable.add(retrofitDI.retrofit().register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }
    private void handleResponse(UserModel.Example userList) {
        Adapter(userList);
    }
    private void handleError(Throwable error) {
        Log.e("TAG","Error" + error.getLocalizedMessage());
    }

    public void Adapter(UserModel.Example userList){
        infoListModels = userList.getResponse();
        adapter = new UserAdapter(infoListModels);
        adapter.notifyDataSetChanged();

        getViewState().setAdapter(adapter);
    }
}
