package com.lingshikeji.xjapp.login.frame;

import com.lingshikeji.xjapp.model.UserEntity;
import com.lingshikeji.xjapp.mvp.BaseView;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:37
 * Description:
 */
public interface ILoginView extends BaseView {
    void loginSuccess(UserEntity userEntity);
}
