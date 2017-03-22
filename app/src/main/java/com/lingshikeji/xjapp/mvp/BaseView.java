package com.lingshikeji.xjapp.mvp;

import android.app.Activity;
import android.content.Context;

/**
 * view 通用操作接口
 * Created by songbinbin on 2015/12/11.
 */
public interface BaseView extends IView {
    /**
     * 获取当前上下文
     *
     * @return
     */
    Context getContext();

    Activity getActivity();

}
