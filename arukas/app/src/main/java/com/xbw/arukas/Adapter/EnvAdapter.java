package com.xbw.arukas.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import com.xbw.arukas.Bean.Envs;
import com.xbw.arukas.R;

import java.util.List;


/**
 * Created by xubowen on 2017/3/22.
 */
public class EnvAdapter extends BaseAdapter {

    private List<Envs> mDate;
    private Context mContext;

    public EnvAdapter(Context mContext, List<Envs> mDate) {
        this.mContext = mContext;
        this.mDate = mDate;
    }

    public List<Envs> getEnvsAdapter() {
        return mDate;
    }

    public void addItem(Envs e) {
        mDate.add(e);
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

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.env_item, null);
            viewHolder = new ViewHolder();
            viewHolder.Et_key = (TextView) convertView.findViewById(R.id.ET_key);
            viewHolder.Et_value = (TextView) convertView.findViewById(R.id.ET_value);
            viewHolder.Img_esub = (ImageView) convertView.findViewById(R.id.Img_Esub);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Envs model = mDate.get(position);
        viewHolder.Et_key.setText(model.getKey());
        viewHolder.Et_value.setText(model.getValue());
        viewHolder.Img_esub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletItem(position);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        private static TextView Et_key;
        private static TextView Et_value;
        private static ImageView Img_esub;
    }
}
