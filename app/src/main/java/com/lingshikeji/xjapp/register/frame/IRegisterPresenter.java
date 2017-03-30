package com.lingshikeji.xjapp.register.frame;

import com.lingshikeji.xjapp.mvp.BasePresenter;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:41
 * <br/>Description:
 * <br/>FIXME
 */

public abstract class IRegisterPresenter extends BasePresenter<IRegisterView> {
    public abstract void register(String email, String pwd);
}
