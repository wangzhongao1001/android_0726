package com.wza.android01.api;

import com.wza.android01.bean.BaseResponse;
import com.wza.android01.bean.ListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MySerivce {
    @GET
    Observable<BaseResponse<List<ListData>>> get(@Url String url);
}
