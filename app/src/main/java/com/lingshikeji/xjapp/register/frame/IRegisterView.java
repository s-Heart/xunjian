package com.lingshikeji.xjapp.register.frame;

import com.lingshikeji.xjapp.model.UserEntity;
import com.lingshikeji.xjapp.mvp.BaseView;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:35
 * Description:
 */
public interface IRegisterView extends BaseView {
    void registerSuccess(UserEntity userEntity);
}
