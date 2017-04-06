package com.lingshikeji.xjapp.view_add_test_plan.frame;

import com.lingshikeji.xjapp.mvp.BasePresenter;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:31
 * Description:
 */
public abstract class IViewTestPlanDetailPresenter extends BasePresenter<IViewTestPlanDetailView> {
    public abstract void queryTestPlanDetail(int testPlanId);

    public abstract void deleteTestPlan(int testPlanId);
}
