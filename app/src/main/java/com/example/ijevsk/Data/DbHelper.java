package com.example.ijevsk.Data;

import com.example.ijevsk.Model.UserModel;
import com.orm.SugarRecord;

import java.util.List;

public class DbHelper extends SugarRecord {

    List<UserModel.Response> responseList;

    public DbHelper() {
    }

    public DbHelper(List<UserModel.Response> responseList) {
        this.responseList = responseList;
    }

    public List<UserModel.Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<UserModel.Response> responseList) {
        this.responseList = responseList;
    }
}
