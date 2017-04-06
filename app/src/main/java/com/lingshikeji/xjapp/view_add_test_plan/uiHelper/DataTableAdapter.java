package com.lingshikeji.xjapp.view_add_test_plan.uiHelper;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.lingshikeji.xjapp.view_add_test_plan.frame.IViewTestPlanDetailPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/4/6.
 */

public class DataTableAdapter extends BaseTableAdapter {

    private final Context context;
    private List<List<String>> datas = new ArrayList<>();
    private final int width;
    private final int height;
    private final static int WIDTH_DIP = 110;
    private final static int HEIGHT_DIP = 32;
    private boolean triggerRequest;
    private IViewTestPlanDetailPresenter iViewTestPlanDetailPresenter;

    public DataTableAdapter(Context context) {
        this.context = context;
        Resources r = context.getResources();
        width = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, WIDTH_DIP, r.getDisplayMetrics()));
        height = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, HEIGHT_DIP, r.getDisplayMetrics()));

        initDefault();
    }

    private void initDefault() {
        List<String> headers = new ArrayList<>();
        headers.add("");
        headers.add("");
        headers.add("");
        headers.add("");
        headers.add("");
        headers.add("");
        headers.add("");
        headers.add("");
        datas.add(headers);
    }

    @Override
    public int getRowCount() {
        return datas.size() - 1;
    }

    @Override
    public int getColumnCount() {
        return datas.get(0).size() - 1;
    }

    @Override
    public View getView(int row, int column, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new TextView(context);
            ((TextView) convertView).setGravity(Gravity.CENTER_VERTICAL);
        }
        if (row == -1) {
            //首行算-1
            convertView.setBackgroundColor(0xff053c6e);//argb
            if (datas.get(row + 1).get(0).isEmpty()) {
                //数据没回来
                convertView.setBackgroundColor(0xffffffff);
            }
        }
        ((TextView) convertView).setText(datas.get(row + 1).get(column + 1).toString());


        if (row == getRowCount() - 1 && !triggerRequest) {
            triggerRequest = true;
            // TODO: 2017/4/6 调接口拿数据
//            iViewTestPlanDetailPresenter.queryDatas();

        }

        return convertView;
    }

    @Override
    public int getHeight(int row) {
        return height;
    }

    @Override
    public int getWidth(int column) {
        return width;
    }

    @Override
    public int getItemViewType(int row, int column) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public void setPresenter(IViewTestPlanDetailPresenter iViewTestPlanDetailPresenter) {
        this.iViewTestPlanDetailPresenter = iViewTestPlanDetailPresenter;
    }
}
