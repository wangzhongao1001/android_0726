package com.wza.android01.view;

import com.wza.android01.bean.ListData;
import com.wza.android01.contarct.MainConract;

import java.util.List;

public interface DataView extends MainConract.MainView {
    void showSuccess(List<ListData> listData);

    void showError(String error);
}
