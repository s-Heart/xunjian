package com.lingshikeji.xjapp.test_mgr.frame;

import com.lingshikeji.xjapp.model.InstrumentEntity;
import com.lingshikeji.xjapp.mvp.BasePresenter;

/**
 * <br/>Author: tony(shishaojie@koolearn.com)
 * <br/>Date: 2017/3/22 0022
 * <br/>Time: 13:41
 * <br/>Description:
 * <br/>FIXME
 */

public abstract class ITestMgrPresenter extends BasePresenter<ITestMgrView> {
    public abstract void queryInstruments();

    public abstract void queryInstrumentsPage(int currentLastItemIndex);

    public abstract void gotoModifyDetail(InstrumentEntity instrumentEntity);
}
