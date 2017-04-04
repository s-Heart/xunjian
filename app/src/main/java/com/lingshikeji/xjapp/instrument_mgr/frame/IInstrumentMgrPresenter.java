package com.lingshikeji.xjapp.instrument_mgr.frame;

import com.lingshikeji.xjapp.model.InstrumentEntity;
import com.lingshikeji.xjapp.mvp.BasePresenter;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:34
 * Description:
 */
public abstract class IInstrumentMgrPresenter extends BasePresenter<IInstrumentMgrView> {
    public abstract void queryInstruments();

    public abstract void queryInstrumentsPage(int currentLastItemIndex);

    public abstract void gotoModifyDetail(InstrumentEntity instrumentEntity);
}
