package com.wza.android01.base;

import android.view.View;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V> {
    private WeakReference<V> weakReference;
    private V mView;
    public void attach(V view){
        weakReference=new WeakReference<>(view);
        mView=weakReference.get();
    }
    public void deatchView(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }
}
