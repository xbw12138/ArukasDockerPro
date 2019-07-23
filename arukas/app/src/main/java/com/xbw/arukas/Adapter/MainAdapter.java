package com.xbw.arukas.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xbw.arukas.Bean.AllappBean;
import com.xbw.arukas.Bean.StartBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.DetailActivity;
import com.xbw.arukas.R;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.FormBody;

public class MainAdapter extends BaseAdapter {
    private List<AllappBean.DataBeanXXXXX.DataBeanXX> mDate;
    private Context mContext;

    public MainAdapter(Context mContext, List<AllappBean.DataBeanXXXXX.DataBeanXX> mDate) {
        this.mContext = mContext;
        this.mDate = mDate;
    }

    public void deletItem(int pos) {
        mDate.remove(pos);
        this.notifyDataSetChanged();
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
            convertView = View.inflate(mContext, R.layout.main_item, null);
            viewHolder = new ViewHolder();
            viewHolder.Tv_name = (TextView) convertView.findViewById(R.id.title);
            viewHolder.TV_id = (TextView) convertView.findViewById(R.id.sub_title);
            viewHolder.TV_time = (TextView) convertView.findViewById(R.id.sub_time);
            viewHolder.Img_del = (ImageView) convertView.findViewById(R.id.remove_item);
            viewHolder.mainLinear = (LinearLayout) convertView.findViewById(R.id.main_linear);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final AllappBean.DataBeanXXXXX.DataBeanXX mainModel = mDate.get(i);
        viewHolder.mainLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mContext, DetailActivity.class);
                intent.putExtra("containerID", mainModel.getRelationships().getServices().getData().get(0).getId());
                intent.putExtra("name", mainModel.getAttributes().getName());
                mContext.startActivity(intent);
            }
        });
        viewHolder.Tv_name.setText(mainModel.getAttributes().getName());
        viewHolder.TV_id.setText(mainModel.getId());
        viewHolder.TV_time.setText(getTime(mainModel.getAttributes().getCreatedat()));
        viewHolder.Img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("警告");
                builder.setMessage("确定要删除" + mainModel.getAttributes().getName() + "吗?删除不可恢复");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //在此写入请求删除docker
                        //deletItem(i);
                        deleteApps(mainModel.getId(), i);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
        return convertView;
    }

    private void deleteApps(String id, final int i) {
        FormBody formBody = new FormBody.Builder()
                .add("api", Config.API_DELETEAPP)
                .add("token", Config.Token)
                .add("appid", id)
                .build();
        HttpClient.getInstance().asyncPost(Config.API, formBody, new HttpClient.HttpCallBack() {
            @Override
            public void onError(okhttp3.Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(mContext, "Network connection failure");
            }

            @Override
            public void onSuccess(okhttp3.Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                StartBean util = gson.fromJson(result, StartBean.class);
                if (util.getStatuscode() == 204) {
                    //刷新状态
                    deletItem(i);
                } else if (util.getStatuscode() == 404) {
                    T.showShort(mContext, "No such service");
                } else if (util.getStatuscode() == 422) {
                    T.showShort(mContext, "Unprocessable Entity");
                } else {
                    T.showShort(mContext, "An unknown error!");
                }
            }
        });
    }

    static class ViewHolder {
        private static TextView Tv_name;
        private static TextView TV_id;
        private static TextView TV_time;
        private static ImageView Img_del;
        private static LinearLayout mainLinear;
    }
    public String getTime(String s) {
        //2018-06-02T15:38:55.087Z
        s = s.replace("Z", "");
        s = s.replace("T", " ");
        String newtime =s;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date d = sd.parse(s);
            long rightTime = (long) (d.getTime() + 8 * 60 * 60 * 1000); //加上8小时对应的毫秒数
            newtime = sd.format(rightTime);
        }catch (Exception e){

        }
        return newtime;
    }

}
