package com.lingshikeji.xjapp.tested_mgr.uihelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingshikeji.xjapp.R;
import com.lingshikeji.xjapp.model.DeviceEntity;
import com.lingshikeji.xjapp.tested_mgr.frame.ITestedMgrPresenter;
import com.lingshikeji.xjapp.tested_mgr.view.TestedMgrActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2017/4/2.
 */

public class DeviceAdapter extends BaseAdapter {
    private final Context context;
    private List<DeviceEntity> datas = new ArrayList<>();
    private ITestedMgrPresenter iTestedMgrPresenter;

    public DeviceAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<DeviceEntity> devices) {
        this.datas = devices;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public DeviceEntity getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return datas.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem_device, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_device_title);
            viewHolder.chooseImg = (CheckBox) convertView.findViewById(R.id.item_device_choose_img);
            viewHolder.checkImg = (ImageView) convertView.findViewById(R.id.item_device_check_img);
            viewHolder.divider = (ImageView) convertView.findViewById(R.id.item_divider_line);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(datas.get(position).getName());

        viewHolder.checkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iTestedMgrPresenter.gotoModifyDetail(getItem(position));
            }
        });

        return convertView;
    }

    public List<DeviceEntity> getDatas() {
        return datas;
    }

    public void setPresenter(ITestedMgrPresenter iTestedMgrPresenter) {
        this.iTestedMgrPresenter = iTestedMgrPresenter;
    }
}
