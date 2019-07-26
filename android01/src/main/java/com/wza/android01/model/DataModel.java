package com.wza.android01.model;

import android.annotation.SuppressLint;

import com.wza.android01.api.MySerivce;
import com.wza.android01.bean.BaseResponse;
import com.wza.android01.bean.ListData;
import com.wza.android01.contarct.MainConract;
import com.wza.android01.http.HttpManager;
import com.wza.android01.utils.RxUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

public class DataModel implements MainConract.MainModle {

    @SuppressLint("CheckResult")
    @Override
    public void getData(final CallBack callBack) {
        HttpManager.getInstance().getServer(MySerivce.class).get("wxarticle/chapters/json")
                .compose(RxUtils.<BaseResponse<List<ListData>>>rxScheduleThread())
                .compose(RxUtils.<List<ListData>>changeResult())
                .subscribe(new Consumer<List<ListData>>() {
                    @Override
                    public void accept(List<ListData> listData) throws Exception {
                        callBack.showSuccess(listData);
                    }
                });

    }
}
