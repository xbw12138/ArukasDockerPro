package com.xbw.arukas.Adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xbw.arukas.Bean.ExtensionBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.R;
import com.xbw.arukas.utils.PackageUtil;
import com.xbw.arukas.utils.T;

import java.util.List;

public class ExtensionAdapter extends BaseAdapter {
    private List<ExtensionBean.DataBean> mDate;
    private Context mContext;

    public ExtensionAdapter(Context mContext, List<ExtensionBean.DataBean> mDate) {
        this.mContext = mContext;
        this.mDate = mDate;
    }

    @Override
    public int getCount() {
        return mDate.size();
    }

    @Override
    public Object getItem(int i) {
        return mDate.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.extension_item, null);
            viewHolder = new ViewHolder();
            viewHolder.TV_appname = (TextView) convertView.findViewById(R.id.tx_appname);
            viewHolder.TV_functionname = (TextView) convertView.findViewById(R.id.tx_functionname);
            viewHolder.Img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            viewHolder.mainLinear = (LinearLayout) convertView.findViewById(R.id.main_linear);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ExtensionBean.DataBean mainModel = mDate.get(i);
        viewHolder.mainLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainModel.getType().equals("web")){
                    PackageUtil.jumpToWeb(mContext, mainModel.getAppstore()+Config.JSONDATA);
                }else if(mainModel.getType().equals("app")) {
                    if (PackageUtil.isAppInstalled(mContext, mainModel.getPackagename())) {
                        try {
                            PackageUtil.jumpToApp(mContext, mainModel.getPackagename(), mainModel.getActivity(), mainModel.getFlag(), Config.JSONDATA, mainModel.getFunctioncode());
                        } catch (Exception e) {
                            T.showShort(mContext, "Jump failed,please install app");
                            PackageUtil.jumpToWeb(mContext, mainModel.getAppstore());
                        }
                    } else {
                        PackageUtil.jumpToWeb(mContext, mainModel.getAppstore());
                    }
                }
            }
        });
        viewHolder.TV_appname.setText(mainModel.getAppname());
        viewHolder.TV_functionname.setText(mainModel.getFunctionname());
        Picasso.with(mContext).load(mainModel.getIcon()).placeholder(R.drawable.ic_launcher).into(viewHolder.Img_icon);
        return convertView;
    }

    static class ViewHolder {
        private static TextView TV_functionname;
        private static TextView TV_appname;
        private static ImageView Img_icon;
        private static LinearLayout mainLinear;
    }
}
