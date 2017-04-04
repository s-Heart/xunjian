package com.lingshikeji.xjapp.view_add_test_plan.presenter;

import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.view_add_test_plan.frame.IViewTestPlanPresenter;
import com.lingshikeji.xjapp.view_add_test_plan.frame.IViewTestPlanView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:31
 * Description:
 */
public class ViewTestPlanPlanPresenterImpl extends IViewTestPlanPresenter {

    @Override
    public void attachView(IViewTestPlanView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void queryTestPlan() {
        getiView().showProgress();
        Observable<List<Object>> observable = NetManager.getInstance().getApiService().queryTestPlan();
        NetManager.getInstance().runRxJava(observable, new Subscriber<List<Object>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(List<Object> objects) {
                getiView().hideProgress();
                getiView().toast("查询成功");
            }
        });
    }
}
