package com.lingshikeji.xjapp.register.frame;

import com.lingshikeji.xjapp.model.UserEntity;
import com.lingshikeji.xjapp.mvp.BaseView;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:42
 * <br/>Description:
 * <br/>FIXME
 */

public interface IRegisterView extends BaseView {
    void registerSuccess(UserEntity userEntity);
}
