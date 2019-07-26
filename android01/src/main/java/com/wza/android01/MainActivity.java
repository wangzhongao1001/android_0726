package com.wza.android01;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wza.android01.adapter.RlvAdapter;
import com.wza.android01.base.BaseActivity;
import com.wza.android01.base.BasePresenter;
import com.wza.android01.bean.ListData;
import com.wza.android01.contarct.MainConract;
import com.wza.android01.model.DataModel;
import com.wza.android01.presenter.DataPresenter;
import com.wza.android01.view.DataView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<DataView,DataPresenter> implements MainConract.MainView {

    @BindView(R.id.rlv)
    RecyclerView rlv;
ArrayList<ListData>list=new ArrayList<>();
    private RlvAdapter rlvAdapter;

    @Override
    protected void initViewandData() {
        mPresenter.http();
        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlvAdapter = new RlvAdapter(list, this);
        rlv.setAdapter(rlvAdapter);

    }

    @Override
    protected int createLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected DataPresenter createPresenter() {
        return new DataPresenter(new DataModel(),this);
    }

    @Override
    public void showSuccess(List<ListData> listData) {
        list.addAll(listData);
        rlvAdapter.setList(list);
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {

    }
}
