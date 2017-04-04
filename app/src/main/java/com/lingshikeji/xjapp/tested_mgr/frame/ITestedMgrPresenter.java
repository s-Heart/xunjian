package com.lingshikeji.xjapp.tested_mgr.frame;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.mvp.BasePresenter;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:33
 * Description:
 */
public abstract class ITestedMgrPresenter extends BasePresenter<ITestedMgrView> {
    public abstract void queryDevices();

    public abstract void queryDevicePage(int currentLastItemIndex);

    public abstract void gotoModifyDetail(DeviceEntity deviceEntity);
}
