package com.lingshikeji.xjapp.device_mgr.frame;

import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.mvp.BaseView;

import java.util.List;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:33
 * Description:
 */
public interface IDeviceMgrView extends BaseView {
    void querySuccess(List<DeviceEntity> devices);

    void queryPageSuccess(List<DeviceEntity> devices);

    void startModify(DeviceEntity deviceEntity);
}
