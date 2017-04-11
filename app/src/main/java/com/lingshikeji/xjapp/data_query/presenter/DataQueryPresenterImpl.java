package com.lingshikeji.xjapp.data_query.presenter;

import android.content.Intent;

import com.lingshikeji.xjapp.data_query.frame.IDataQueryPresenter;
import com.lingshikeji.xjapp.data_query.frame.IDataQueryView;
import com.lingshikeji.xjapp.model.TestPlanGroup;
import com.lingshikeji.xjapp.net.NetManager;
import com.lingshikeji.xjapp.view_add_test_plan.view.ViewTestPlanDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:38
 * Description:
 */
public class DataQueryPresenterImpl extends IDataQueryPresenter {

    @Override
    public void attachView(IDataQueryView iView) {
        super.attachView(iView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void queryLastDayTestPlan() {
//        where={"createdAt":{">":"2017-04-02T00:00:00.000Z", "<":"2017-04-03T00:00:00.000Z"},"device":"3"}
        getiView().showProgress();

        Map<String, String> params = new HashMap<>();
        params.put("sort", "createdAt DESC");
        params.put("limit", "1");
        params.put("populate", "device,instrument");
        Observable<List<TestPlanGroup>> observable = NetManager.getInstance().getApiService().queryTestPlan(params);
        NetManager.getInstance().runRxJava(observable, new Subscriber<List<TestPlanGroup>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getiView().hideProgress();
                getiView().toast(e.getMessage());
            }

            @Override
            public void onNext(List<TestPlanGroup> testPlanEntities) {
                getiView().hideProgress();
                getiView().querySuccess(testPlanEntities);
            }
        });
    }

    @Override
    public void goTestPlanDetail(int testPlanId) {
        Intent intent = new Intent(getiView().getContext(), ViewTestPlanDetailActivity.class);
        intent.putExtra("testPlanId", testPlanId);
        getiView().getActivity().startActivityForResult(intent, 0);
    }
}
