package com.lingshikeji.xjapp.tested_mgr.frame;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.mvp.BaseView;

import java.util.List;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:42
 * <br/>Description:
 * <br/>FIXME
 */

public interface ITestedMgrView extends BaseView {
    void querySuccess(List<DeviceEntity> devices);

    void queryPageSuccess(List<DeviceEntity> devices);
}
