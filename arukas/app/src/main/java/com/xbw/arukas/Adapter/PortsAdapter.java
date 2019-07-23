package com.xbw.arukas.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xbw.arukas.Bean.Ports;
import com.xbw.arukas.R;

import java.util.List;

/**
 * Created by xubowen on 2017/3/23.
 */
public class PortsAdapter extends BaseAdapter {
    private List<Ports> mDate;
    private Context mContext;

    public PortsAdapter(Context mContext, List<Ports> mDate) {
        this.mContext = mContext;
        this.mDate = mDate;
    }

    public List<Ports> getPortsAdapter() {
        return mDate;
    }

    public void addItem(Ports p) {
        mDate.add(p);
        this.notifyDataSetChanged();
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
    public Object getItem(int position) {
        return mDate.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.ports_item, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_port = (TextView) convertView.findViewById(R.id.ET_portt);
            viewHolder.txt_cont = (TextView) convertView.findViewById(R.id.ET_cont);
            viewHolder.img_sub = (ImageView) convertView.findViewById(R.id.Img_Psub);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Ports model = mDate.get(position);
        viewHolder.txt_port.setText(model.getNumber() + "");
        viewHolder.txt_cont.setText(model.getProtocol() + "");
        viewHolder.img_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletItem(position);
            }
        });
        // 返回
        return convertView;
    }

    static class ViewHolder {
        private static TextView txt_port;
        private static TextView txt_cont;
        private static ImageView img_sub;
    }
}
