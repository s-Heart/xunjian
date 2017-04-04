package com.lingshikeji.xjapp.view_add_test_plan.uiHelper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.model.TestPlanEntity;
import com.lingshikeji.xjapp.view_add_test_plan.view.ViewTestPlanActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/4/4.
 */

public class ExpandLvAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private List<TestPlanEntity> datas = new ArrayList<>();

    public ExpandLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<TestPlanEntity> datas) {
        this.datas.clear();//不能重新赋值，只能清除之后addAll
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return datas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return datas.get(groupPosition).getDevices().size();
    }

    @Override
    public TestPlanEntity getGroup(int groupPosition) {
        return datas.get(groupPosition);
    }

    @Override
    public TestPlanEntity getChild(int groupPosition, int childPosition) {
        return datas.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;// FIXME: 2017/4/4
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expand_group_test_plan, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvStartTime = (TextView) convertView.findViewById(R.id.tv_tp_start_time);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.tvStartTime.setText(getGroup(groupPosition).getCreatedAt());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expand_child_test_plan, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvInstrument = (TextView) convertView.findViewById(R.id.tv_instrument);
            childViewHolder.tvDevice = (TextView) convertView.findViewById(R.id.tv_device);
            childViewHolder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            childViewHolder.rlMore = (RelativeLayout) convertView.findViewById(R.id.rl_more);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        String instrumentName = datas.get(groupPosition).getInstruments().get(childPosition).getName();
        String deviceName = datas.get(groupPosition).getDevices().get(childPosition).getName();
        String state = datas.get(groupPosition).getStatus().get(childPosition);
        String status = "";
        if (state.equals("notstart")) {
            status = "未开始";
        } else if (state.equals("running")) {
            status = "运行中";
        } else if (state.equals("stopped")) {
            status = "停止";
        }

        childViewHolder.tvInstrument.setText(instrumentName);
        childViewHolder.tvDevice.setText(deviceName);
        childViewHolder.tvState.setText(status);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class GroupViewHolder {
        public TextView tvStartTime;
    }

    private class ChildViewHolder {
        public TextView tvInstrument;
        public TextView tvDevice;
        public TextView tvState;
        public RelativeLayout rlMore;
    }
}
