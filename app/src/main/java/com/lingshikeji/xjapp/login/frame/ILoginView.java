package com.lingshikeji.xjapp.login.frame;

import com.lingshikeji.xjapp.model.User;
import com.lingshikeji.xjapp.mvp.BaseView;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:42
 * <br/>Description:
 * <br/>FIXME
 */

public interface ILoginView extends BaseView {
    void loginSuccess(User user);
}
