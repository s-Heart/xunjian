package com.lingshikeji.xjapp.view_add_test_plan.presenter;

import com.lingshikeji.xjapp.model.TestPlanDetailEntity;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.view_add_test_plan.frame.IViewTestPlanDetailPresenter;
import com.lingshikeji.xjapp.view_add_test_plan.frame.IViewTestPlanDetailView;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:31
 * Description:
 */
public class ViewTestPlanDetailPresenterImpl extends IViewTestPlanDetailPresenter {

    @Override
    public void attachView(IViewTestPlanDetailView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void queryTestPlanDetail(int testPlanId) {
        getiView().showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("populate", "instrument,device");//展开测试，被测对象，并返回
        Observable<TestPlanDetailEntity> observable = NetManager.getInstance().getApiService().queryTestPlanDetail(testPlanId, params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<TestPlanDetailEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(TestPlanDetailEntity testPlanDetailEntity) {
                getiView().hideProgress();
                getiView().queryDetailSuccess(testPlanDetailEntity);
            }
        });
    }

    @Override
    public void deleteTestPlan(int testPlanId) {
        getiView().showProgress();
        Observable<Object> observable=NetManager.getInstance().getApiService().deleteTestPlan(testPlanId);

        NetManager.getInstance().runRxJava(observable, new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                getiView().hideProgress();
                getiView().toast("删除成功");
                getiView().deleteTestPlanSuccess();
            }
        });
    }
}
