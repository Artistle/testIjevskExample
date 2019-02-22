package com.example.ijevsk;

import com.arellomobile.mvp.MvpView;
import com.example.ijevsk.Presenter.Adapters.UserAdapter;


public interface View extends MvpView {
    public void setAdapter(UserAdapter adapter);
}
