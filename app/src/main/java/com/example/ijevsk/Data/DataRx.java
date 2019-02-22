package com.example.ijevsk.Data;

import com.example.ijevsk.Model.UserModel;
import com.example.ijevsk.RetrofitDI.RetrofitDI;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DataRx extends SugarRecord {
    @Inject
    RetrofitDI retrofitDI = new RetrofitDI();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<UserModel.Response> list = new ArrayList<UserModel.Response>();
    private DbHelper dbHelper;

    public void Load(){
        compositeDisposable.add(retrofitDI.retrofit().register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::handleResponse, this::handleError));
    }
    private void handleError(Throwable throwable) {

    }
    private void handleResponse(UserModel.Example example) {
        list = example.getResponse();
        initDB(list);
    }

    public void initDB(List<UserModel.Response> listDB){
        dbHelper = new DbHelper(listDB);
        dbHelper.save();

        dbHelper.getResponseList();
    }
}
