package com.lingshikeji.xjapp.tested_mgr.frame;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.mvp.BasePresenter;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:41
 * <br/>Description:
 * <br/>FIXME
 */

public abstract class ITestedMgrPresenter extends BasePresenter<ITestedMgrView> {
    public abstract void queryDevices();

    public abstract void queryDevicePage(int currentLastItemIndex);

    public abstract void gotoModifyDetail(DeviceEntity deviceEntity);
}
