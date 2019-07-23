package com.xbw.arukas;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.xbw.arukas.Adapter.ExtensionAdapter;
import com.xbw.arukas.Adapter.MainAdapter;
import com.xbw.arukas.Bean.AllappBean;
import com.xbw.arukas.Bean.ErrorBean;
import com.xbw.arukas.Bean.ExtensionBean;
import com.xbw.arukas.Config.Config;
import com.xbw.arukas.utils.HttpClient;
import com.xbw.arukas.utils.T;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.Request;

public class ExtensionActivity extends AppCompatActivity {

    @BindView(R.id.listview_extension)
    ListView listviewExtension;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;
    @BindView(R.id.frame_nodata)
    FrameLayout frameLayout;

    private ExtensionAdapter extensionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension);
        ButterKnife.bind(this);
        getExtension();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getExtension();
            }
        });
    }
    public void getExtension(){
        HttpClient.getInstance().asyncGet(Config.API_EXTENSION, new HttpClient.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                Log.d("xbw12138", e.toString());
                T.showShort(getBaseContext(), "Network connection failure");
                swipeContainer.setRefreshing(false);
            }
            @Override
            public void onSuccess(Request request, String result) {
                Log.d("xbw12138", result);
                Gson gson = new Gson();
                ExtensionBean util = gson.fromJson(result,ExtensionBean.class);
                if (util.getStatuscode() == 200) {
                    if (util.getData().size() == 0) {
                        frameLayout.setVisibility(View.VISIBLE);
                        listviewExtension.setVisibility(View.GONE);
                    } else {
                        frameLayout.setVisibility(View.GONE);
                        listviewExtension.setVisibility(View.VISIBLE);
                        extensionAdapter = new ExtensionAdapter(ExtensionActivity.this, util.getData());
                        listviewExtension.setAdapter(extensionAdapter);
                    }
                } else {
                    ErrorBean error = gson.fromJson(result, ErrorBean.class);
                    T.showShort(getBaseContext(), error.getData().getErrors().get(0).getTitle().toString());
                }
                swipeContainer.setRefreshing(false);
            }
        });
    }
}
