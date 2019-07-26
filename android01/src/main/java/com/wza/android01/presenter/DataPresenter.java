package com.wza.android01.presenter;

import com.wza.android01.base.BasePresenter;
import com.wza.android01.bean.ListData;
import com.wza.android01.contarct.MainConract;
import com.wza.android01.view.DataView;

import java.util.List;

public class DataPresenter extends BasePresenter<DataView> implements MainConract.MainPresenter, MainConract.MainModle.CallBack {
    MainConract.MainModle mModel;
    MainConract.MainView mView;

    public DataPresenter(MainConract.MainModle mModel, MainConract.MainView mView) {
        this.mModel = mModel;
        this.mView = mView;
    }

    @Override
    public void http() {
        if (mModel!=null){
            mModel.getData(this);
        }
    }

    @Override
    public void showSuccess(List<ListData> listData) {
        if (mView!=null){
            mView.showSuccess(listData);
        }
    }

    @Override
    public void showError(String error) {
        if (mView!=null){
            mView.showError(error);
        }
    }
}
