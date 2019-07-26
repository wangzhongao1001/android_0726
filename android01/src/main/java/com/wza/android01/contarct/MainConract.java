package com.wza.android01.contarct;

import com.wza.android01.bean.ListData;

import java.util.List;

public interface MainConract {
    interface MainView{

        void showSuccess(List<ListData> listData);

        void showError(String error);
    }


    interface MainPresenter{
        void http();
    }


    interface MainModle{
        interface CallBack{
            void showSuccess(List<ListData>listData);

            void showError(String error);
        }
        void getData(CallBack callBack);
    }
}
