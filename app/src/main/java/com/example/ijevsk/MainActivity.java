package com.example.ijevsk;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ijevsk.Data.DataRx;
import com.example.ijevsk.Presenter.Adapters.UserAdapter;
import com.example.ijevsk.Presenter.Presenter;
import com.example.ijevsk.View.View;

public class MainActivity extends MvpActivity implements View {
    private RecyclerView recyclerView;
    private DataRx dataRx;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataRx = new DataRx();
        initRecyclerView();

        presenter.loadJson();
        dataRx.Load();
    }
    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void setAdapter(UserAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
