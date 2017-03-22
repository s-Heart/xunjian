package com.lingshikeji.xjapp.mvp;


public interface Presenter<V extends IView> {
    void attachView(V iView);

    void detachView();

}
